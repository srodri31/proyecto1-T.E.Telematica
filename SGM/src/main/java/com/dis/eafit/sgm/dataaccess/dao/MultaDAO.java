package com.dis.eafit.sgm.dataaccess.dao;

import com.dis.eafit.sgm.dataaccess.api.JpaDaoImpl;
import com.dis.eafit.sgm.modelo.Multa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MultaDAO extends JpaDaoImpl<Multa, Long> implements IMultaDAO {
    private static final Logger log = LoggerFactory.getLogger(MultaDAO.class);
    @PersistenceContext
    private EntityManager entityManager;
}
