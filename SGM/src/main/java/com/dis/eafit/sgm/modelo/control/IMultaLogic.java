package com.dis.eafit.sgm.modelo.control;

import com.dis.eafit.sgm.modelo.Multa;
import com.dis.eafit.sgm.modelo.dto.MultaDTO;

import java.math.BigDecimal;

import java.util.*;
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
public interface IMultaLogic {
    public List<Multa> getMulta() throws Exception;

    /**
         * Save an new Multa entity
         */
    public void saveMulta(Multa entity) throws Exception;

    /**
         * Delete an existing Multa entity
         *
         */
    public void deleteMulta(Multa entity) throws Exception;

    /**
        * Update an existing Multa entity
        *
        */
    public void updateMulta(Multa entity) throws Exception;

    /**
         * Load an existing Multa entity
         *
         */
    public Multa getMulta(Long id) throws Exception;

    public List<Multa> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Multa> findPageMulta(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberMulta() throws Exception;

    public List<MultaDTO> getDataMulta() throws Exception;
}
