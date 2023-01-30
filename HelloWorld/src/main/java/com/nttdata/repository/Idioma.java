package com.nttdata.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



/**
 * Entidad Idioma(Spring Data)Clase de la entidad Idioma en Spring Data
 */
@Entity
@Table(name = "T_IDIOMA")
public class Idioma implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Id Idioma (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequenciaIdioma")
	@SequenceGenerator(name="sequenciaIdioma",sequenceName="SEQ_IDIOMA", allocationSize=1)
	@Column(name = "C_ID")
	private Long id;

	/** Nombre Idioma */
	@Column(name = "C_NOMBRE")
	private String nombre;

	/** Saludo Idioma */
	@Column(name = "C_SALUDO")
	private String saludo;
	
	/** Acronimo Idioma */
	@Column(name = "C_ACRONIMO")
	private String acronimo;

	/**
	 * Getters & Setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
	
	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}
}