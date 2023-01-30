package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.repository.Idioma;
import com.nttdata.repository.RepositorioIdiomaI;

/**
 * Implementación de interfaz del servicio para la gestión de idiomas
 * @author PAA
 */
@Service
public class ServicioGestionIdiomaImpl implements ServicioGestionIdiomaI {

	/** Repositorio de idiomas */
	@Autowired
	private RepositorioIdiomaI repositorioIdioma;

	@Override
	public void introducirNuevoIdioma(Idioma idioma) {
		repositorioIdioma.save(idioma);
	}

	@Override
	public void eliminarIdioma(Idioma idioma) {
		repositorioIdioma.delete(idioma);
	}

	@Override
	public void actualizaIdioma(Idioma idioma, String nombre, String acronimo, String saludo) {
		Idioma idiom = repositorioIdioma.getById(idioma.getId());
		idiom.setNombre(nombre);
		idiom.setAcronimo(acronimo);
		idiom.setSaludo(saludo);
		repositorioIdioma.save(idiom);
	}

	@Override
	public List<Idioma> getAll() {
		return repositorioIdioma.findAll();
	}

	@Override
	public Idioma buscarId(Long id) {
		return repositorioIdioma.getById(id);
	}

	@Override
	public String saludo(String acronimo) {
		List<Idioma> listaIdioma = repositorioIdioma.findByAcronimo(acronimo);
		return listaIdioma.get(0).getSaludo();
	}
}