package com.nttdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio entidad Idioma(Spring Data)
 * @author PAA
 */
public interface RepositorioIdiomaI extends JpaRepository<Idioma, Long>{
	
	/**
	 * Funcion para buscar idioma por su nombre.
	 * @param nombre 
	 * @return Lista de idiomas buscados por consulta.
	 */
	List<Idioma> findByNombre(final String nombre);
	
	/**
	 * Funcion para buscar idioma por su acronimo.
	 * @param acronimo 
	 * @return Lista de idiomas buscados por consulta.
	 */
	List<Idioma> findByAcronimo(final String acronimo);
}

