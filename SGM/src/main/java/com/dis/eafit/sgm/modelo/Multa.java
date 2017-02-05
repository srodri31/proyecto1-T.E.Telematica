package com.dis.eafit.sgm.modelo;
// Generated 2/02/2017 10:48:54 PM by Hibernate Tools 5.1.0.Final

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "multa", catalog = "telematica")
public class Multa implements java.io.Serializable {

	private static final long serialVersionUID = -1746747858721811197L;
	
	private Long id;
	private BigDecimal valor;
	private Persona persona;
	private Date fechaPago;

	public Multa() {
	}

	public Multa(Long id, BigDecimal valor) {
		this.id = id;
		this.valor = valor;
	}

	@Id
	@Column(name = "id")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "valor", nullable = false, precision = 10, scale = 0)
	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_pago")
	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Persona.class)
	@JoinColumn(name = "id_persona", referencedColumnName = "id")
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	

}
