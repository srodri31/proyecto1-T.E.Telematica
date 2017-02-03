package com.dis.eafit.sgm.presentation.businessDelegate;

import com.dis.eafit.sgm.modelo.Multa;
import com.dis.eafit.sgm.modelo.control.IMultaLogic;
import com.dis.eafit.sgm.modelo.control.MultaLogic;
import com.dis.eafit.sgm.modelo.dto.MultaDTO;
import com.dis.eafit.sgm.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @EJB
    private IMultaLogic multaLogic;

    public List<Multa> getMulta() throws Exception {
        return multaLogic.getMulta();
    }

    public void saveMulta(Multa entity) throws Exception {
        multaLogic.saveMulta(entity);
    }

    public void deleteMulta(Multa entity) throws Exception {
        multaLogic.deleteMulta(entity);
    }

    public void updateMulta(Multa entity) throws Exception {
        multaLogic.updateMulta(entity);
    }

    public Multa getMulta(Long id) throws Exception {
        Multa multa = null;

        try {
            multa = multaLogic.getMulta(id);
        } catch (Exception e) {
            throw e;
        }

        return multa;
    }

    public List<Multa> findByCriteriaInMulta(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return multaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Multa> findPageMulta(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return multaLogic.findPageMulta(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberMulta() throws Exception {
        return multaLogic.findTotalNumberMulta();
    }

    public List<MultaDTO> getDataMulta() throws Exception {
        return multaLogic.getDataMulta();
    }
}
