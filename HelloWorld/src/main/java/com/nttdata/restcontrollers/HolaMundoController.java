package com.nttdata.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.services.ServicioGestionIdiomaI;

import io.swagger.v3.oas.annotations.Operation;

/**
 * Clase Controlador para saludos
 * @author PAA
 */
@RestController
@RequestMapping("/home/saludo/")
public class HolaMundoController {
	
	/** Servicio de Idiomas */
	@Autowired
	private ServicioGestionIdiomaI servicioIdioma;
	
	/** Saludo en archivo de configuracion */
	@Value("${mensaje:Hola default}")
	private String mensaje;
	
	/**
	 * Saludo del archivo de configuracion de proyecto mediante solicitud Get.
	 * @return saludo
	 */
	@Operation(summary="Expone saludo del archivo de configuracion de proyecto")
	@GetMapping("/mensaje")
	public @ResponseBody String getMensaje() {
		return this.mensaje;
	}
	
	/**
	 * Saludo en el idioma que se indica por parametros mediante solicitud Get.
	 * @param acronimo
	 * @return Saludo en el idioma indicado
	 */
	@Operation(summary="Expone saludo en el idioma indicado")
	@GetMapping("/{acronimo}")
	public @ResponseBody String saludoEspanhol(final @PathVariable String acronimo) {
		return servicioIdioma.saludo(acronimo);
	}	
}