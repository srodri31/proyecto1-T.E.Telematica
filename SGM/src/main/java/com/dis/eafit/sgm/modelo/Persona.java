package com.dis.eafit.sgm.modelo;
// Generated 2/02/2017 10:48:54 PM by Hibernate Tools 5.1.0.Final

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona", catalog = "telematica")
public class Persona implements java.io.Serializable {

	private static final long serialVersionUID = 7764709575861265624L;
	
	private Long id;
	private String nombre;
	private Long telefono;
	private Long documentoIdentidad;
	private String correo;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "telefono")
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	
	@Column(name = "documento_identidad")
	public Long getDocumentoIdentidad() {
		return documentoIdentidad;
	}
	public void setDocumentoIdentidad(Long documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}
	
	@Column(name = "correo")
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
}

