package com.dis.eafit.sgm.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dis.eafit.sgm.modelo.Persona;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.*;

import java.util.Date;

public class MultaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(MultaDTO.class);
    private Long id;
    private BigDecimal valor;
    private Date fechaPago;
    private Persona persona;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
    
    
}
