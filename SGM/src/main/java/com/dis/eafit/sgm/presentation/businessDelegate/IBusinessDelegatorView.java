package com.dis.eafit.sgm.presentation.businessDelegate;

import com.dis.eafit.sgm.modelo.Multa;
import com.dis.eafit.sgm.modelo.control.IMultaLogic;
import com.dis.eafit.sgm.modelo.control.MultaLogic;
import com.dis.eafit.sgm.modelo.dto.MultaDTO;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Local
public interface IBusinessDelegatorView {
    public List<Multa> getMulta() throws Exception;

    public void saveMulta(Multa entity) throws Exception;

    public void deleteMulta(Multa entity) throws Exception;

    public void updateMulta(Multa entity) throws Exception;

    public Multa getMulta(Long id) throws Exception;

    public List<Multa> findByCriteriaInMulta(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Multa> findPageMulta(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberMulta() throws Exception;

    public List<MultaDTO> getDataMulta() throws Exception;
}
