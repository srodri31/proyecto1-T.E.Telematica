package com.dis.eafit.sgm.dataaccess.dao;

import com.dis.eafit.sgm.dataaccess.api.Dao;
import com.dis.eafit.sgm.modelo.Multa;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;


/**
* Interface for   MultaDAO.
*
*/
@Local
public interface IMultaDAO extends Dao<Multa, Long> {
}
