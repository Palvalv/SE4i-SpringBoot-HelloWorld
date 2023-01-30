package com.nttdata.services;

import java.util.List;

import com.nttdata.repository.Idioma;

/**
 * Interfaz del servicio de gestión de idiomas
 * @author PAA
 */
public interface ServicioGestionIdiomaI {

	/**
	 * Crea un nuevo idioma en el repositorio
	 * @param idioma
	 */
	void introducirNuevoIdioma(final Idioma idioma);

	/**
	 * Elimina un idioma del repositorio
	 * @param idioma
	 */
	void eliminarIdioma(final Idioma idioma);

	/**
	 * Actualiza un idioma existente en el repositorio 
	 * @param idioma
	 * @param nombre Que se va a asignar al idioma
	 * @param acronimo Que se va a asignar al idioma
	 */
	void actualizaIdioma(final Idioma idioma, String nombre, String acronimo, String saludo);

	/**
	 * Busca todos los idiomas existentes en el repositorio
	 * @return Lista de todos los idiomas del repositorio
	 */
	List<Idioma> getAll();
	
	/**
	 * Busca un idioma por su id en el repositorio
	 * @param id  
	 * @return Idioma encontrado
	 */
	Idioma buscarId(Long id);
	
	/**
	 * Muestra el saludo de un idioma por su acronimo
	 * @param acronimo 
	 * @return Saludo del idioma seleccionado
	 */
	String saludo(String acronimo);
	
}