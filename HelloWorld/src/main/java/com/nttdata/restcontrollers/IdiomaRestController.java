package com.nttdata.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.repository.Idioma;
import com.nttdata.services.ServicioGestionIdiomaI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;

/**
 * Clase controlador REST para repositorio de Idiomas que configura los endpoints.
 * @author PAA
 */
@Api(value = "User Rest Controller", description = "REST API for User")
@RestController
@RequestMapping("/home/idioma/")
public class IdiomaRestController {

	/** Servicio de Idiomas */
	@Autowired
	private ServicioGestionIdiomaI servicioIdioma;
	
	/**
	 * Respuesta de la lista con todos los idiomas del repositorio mediante solicitud Get.
	 * @return Lista de idiomas del repositorio
	 */

	@ApiOperation(value = "Listar Idiomas", response = Iterable.class, tags = "todos")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success|OK")})
	@Operation(summary="Expone todos los idiomas del repositorio")
	@GetMapping("/todos")
	public List<Idioma> muestraTodos(){
		return servicioIdioma.getAll();
	}
	
	/**
	 * Introduce un nuevo idioma en el repositorio mediante solicitud Post.
	 * @param nuevoIdioma
	 * @return Idioma introducido correctamente
	 */
	@ApiOperation(value = "Introducir Idiomas", response = Iterable.class, tags = "introducir")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success|OK")})
	@Operation(summary="Introducir idioma en el repositorio")
	@PostMapping("/introducir")
	public String introducirIdioma(final @RequestBody Idioma nuevoIdioma) {
		servicioIdioma.introducirNuevoIdioma(nuevoIdioma);
		return "Idioma introducido en el repositorio";
	}
	
	/**
	 * Actualiza un idioma del repositorio mediante solicitud Put.
	 * @param actualizaIdioma
	 * @param id Id idioma a actualizar 
	 * @return Idioma actualizado correctamente
	 */
	@ApiOperation(value = "Actualizar Idiomas", response = Iterable.class, tags = "actualizar")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success|OK")})
	@Operation(summary="Actualizar idioma del repositorio")
	@PutMapping("/actualizar/{id}")
	public String actualizaIdioma(final @RequestBody Idioma actualizadoIdioma, final @PathVariable Long id) {
		servicioIdioma.actualizaIdioma(servicioIdioma.buscarId(id),actualizadoIdioma.getNombre() , actualizadoIdioma.getAcronimo(), actualizadoIdioma.getSaludo());
		return "Idioma actualizado en el Repositorio";
	}
	
	/**
	 * Elimina un idioma del repositorio mediante solicitud Delete.
	 * @param id Id idioma a eliminar 
	 * @return Idioma eliminado correctamente
	 */
	@ApiOperation(value = "Eliminar Idiomas", response = Iterable.class, tags = "eliminar")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success|OK")})
	@Operation(summary="Eliminar idioma del repositorio")
	@DeleteMapping(value="/eliminar/{id}")
	public String eliminarIdioma(final @PathVariable Long id) {
		Idioma eliminarIdioma=servicioIdioma.buscarId(id);
		servicioIdioma.eliminarIdioma(eliminarIdioma);
		return "Idioma eliminado del Repositorio";
	}
}