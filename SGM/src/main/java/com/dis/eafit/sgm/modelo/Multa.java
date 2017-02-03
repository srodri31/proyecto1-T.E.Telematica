package com.dis.eafit.sgm.modelo;
// Generated 2/02/2017 10:48:54 PM by Hibernate Tools 5.1.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "multa", catalog = "telematica")
public class Multa implements java.io.Serializable {

	private static final long serialVersionUID = -1746747858721811197L;
	private Long id;
	private Long valor;

	public Multa() {
	}

	public Multa(Long id, Long valor) {
		this.id = id;
		this.valor = valor;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "valor", nullable = false, precision = 10, scale = 0)
	public Long getValor() {
		return this.valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

}
