package com.dis.eafit.sgm.dataaccess.dao;

import com.dis.eafit.sgm.dataaccess.api.JpaDaoImpl;
import com.dis.eafit.sgm.modelo.Persona;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonaDAO extends JpaDaoImpl<Persona, Long> implements IPersonaDAO {
    private static final Logger log = LoggerFactory.getLogger(PersonaDAO.class);
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Persona> findByCedula(Long cc){
    	String condition = " documento_identidad = "+cc;
    	return findByCriteria(condition);
    }
}
