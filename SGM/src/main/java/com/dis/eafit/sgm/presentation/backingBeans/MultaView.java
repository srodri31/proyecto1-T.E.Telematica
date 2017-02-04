package com.dis.eafit.sgm.presentation.backingBeans;

import com.dis.eafit.sgm.exceptions.*;
import com.dis.eafit.sgm.modelo.*;
import com.dis.eafit.sgm.modelo.dto.MultaDTO;
import com.dis.eafit.sgm.presentation.businessDelegate.*;
import com.dis.eafit.sgm.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@ViewScoped
public class MultaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(MultaView.class);
    private InputText txtValor;
    private InputText txtId;
    private Calendar calendar;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<MultaDTO> data;
    private MultaDTO selectedMulta;
    private MultaDTO multaDTO;
    private Multa entity;
    private Date fechaPago;
    private boolean showDialog;
    
    @EJB
    private IBusinessDelegatorView businessDelegatorView;

    public MultaView() {
        super();
    }
    
    @PostConstruct
    public void init(){
    	multaDTO = new MultaDTO();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            MultaDTO multaDTO = (MultaDTO) e.getObject();	

            if (txtValor == null) {
                txtValor = new InputText();
            }

            txtValor.setValue(multaDTO.getValor());

            if (txtId == null) {
                txtId = new InputText();
            }

            txtId.setValue(multaDTO.getId());

            Long id = FacesUtils.checkLong(txtId);
            entity = businessDelegatorView.getMulta(id);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedMulta = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedMulta = null;

        if (txtValor != null) {
            txtValor.setValue(null);
            txtValor.setDisabled(true);
        }

        if (txtId != null) {
            txtId.setValue(null);
            txtId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            Long id = FacesUtils.checkLong(txtId);
            entity = (id != null) ? businessDelegatorView.getMulta(id) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtValor.setDisabled(false);
            txtId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtValor.setValue(entity.getValor());
            txtValor.setDisabled(false);
            txtId.setValue(entity.getId());
            txtId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedMulta = (MultaDTO) (evt.getComponent().getAttributes()
                                       .get("selectedMulta"));
        txtValor.setValue(selectedMulta.getValor());
        txtValor.setDisabled(false);
        txtId.setValue(selectedMulta.getId());
        txtId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedMulta == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new Multa();

            Long id = FacesUtils.checkLong(txtId);

            entity.setId(id);
            entity.setValor(multaDTO.getValor());
            entity.setFechaPago(multaDTO.getFechaPago());
            businessDelegatorView.saveMulta(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Long id = new Long(selectedMulta.getId());
                entity = businessDelegatorView.getMulta(id);
            }

            entity.setValor(FacesUtils.checkBigDecimal(txtValor));
            businessDelegatorView.updateMulta(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedMulta = (MultaDTO) (evt.getComponent().getAttributes()
                                           .get("selectedMulta"));

            Long id = new Long(selectedMulta.getId());
            entity = businessDelegatorView.getMulta(id);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long id = FacesUtils.checkLong(txtId);
            entity = businessDelegatorView.getMulta(id);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteMulta(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String actionDeleteDataTableEditable(ActionEvent evt) {
        try {
            selectedMulta = (MultaDTO) (evt.getComponent().getAttributes()
                                           .get("selectedMulta"));

            Long id = new Long(selectedMulta.getId());
            entity = businessDelegatorView.getMulta(id);
            businessDelegatorView.deleteMulta(entity);
            data.remove(selectedMulta);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long id, Long valor)
        throws Exception {
        try {
            entity.setValor(FacesUtils.checkBigDecimal(valor));
            businessDelegatorView.updateMulta(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("MultaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtValor() {
        return txtValor;
    }

    public void setTxtValor(InputText txtValor) {
        this.txtValor = txtValor;
    }

    public InputText getTxtId() {
        return txtId;
    }

    public void setTxtId(InputText txtId) {
        this.txtId = txtId;
    }

    public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public List<MultaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataMulta();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<MultaDTO> multaDTO) {
        this.data = multaDTO;
    }
    
    public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public MultaDTO getSelectedMulta() {
        return selectedMulta;
    }

    public void setSelectedMulta(MultaDTO multa) {
        this.selectedMulta = multa;
    }
    

    public MultaDTO getMultaDTO() {
		return multaDTO;
	}

	public void setMultaDTO(MultaDTO multaDTO) {
		this.multaDTO = multaDTO;
	}

	public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
