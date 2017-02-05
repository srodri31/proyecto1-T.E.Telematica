package com.dis.eafit.sgm.dataaccess.dao;

import com.dis.eafit.sgm.dataaccess.api.Dao;
import com.dis.eafit.sgm.modelo.Persona;

import java.util.List;

import javax.ejb.Local;


/**
* Interface for   MultaDAO.
*
*/
@Local
public interface IPersonaDAO extends Dao<Persona, Long> {
	
	public List<Persona> findByCedula(Long cc);
}
