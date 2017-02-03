package com.dis.eafit.sgm.dataaccess.dao;

import com.dis.eafit.sgm.dataaccess.api.JpaDaoImpl;
import com.dis.eafit.sgm.modelo.Multa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Multa entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Multa
 */
@Stateless
public class MultaDAO extends JpaDaoImpl<Multa, Long> implements IMultaDAO {
    private static final Logger log = LoggerFactory.getLogger(MultaDAO.class);
    @PersistenceContext
    private EntityManager entityManager;
}
