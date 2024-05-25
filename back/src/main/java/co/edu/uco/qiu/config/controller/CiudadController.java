package co.edu.uco.qiu.config.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.qiu.config.business.facade.impl.ciudad.ConsultarCiudadesFacade;
import co.edu.uco.qiu.config.business.facade.impl.ciudad.RegistrarCiudadFacade;
import co.edu.uco.qiu.config.controller.response.CiudadResponse;
import co.edu.uco.qiu.config.crosscutting.exceptions.QIUException;
import co.edu.uco.qiu.config.dto.localizacion.CiudadDTO;

@RestController
@RequestMapping("api/v1/ciudades")
public final class CiudadController {
	
	@GetMapping("/dummy")
	public CiudadDTO dummy()
	{
		return new CiudadDTO();
	}
	
	@PostMapping()
	public ResponseEntity<CiudadResponse> crear(@RequestBody CiudadDTO ciudad)
	{
		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();
		
		try 
		{
			var facade = new RegistrarCiudadFacade();
			facade.execute(ciudad);
			ciudadResponse.getMensajes().add("Ciudades creada con éxito.");
		} 
		catch (QIUException qe) {
			
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(qe.getUserMesaage());
			qe.printStackTrace();
		} 
		catch (Exception e)
		{
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var userMessage = "Se ha presentado un problema registrando la información de la nueva ciudad.";
			ciudadResponse.getMensajes().add(userMessage);
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(ciudadResponse, httpStatusCode);
	}
	
	@GetMapping()
	public ResponseEntity<CiudadResponse> consultar()
	{
		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();
		
		try 
		{
			var ciudad = new CiudadDTO();
			var facade = new ConsultarCiudadesFacade();
			ciudadResponse.setDatos(facade.execute(ciudad));
			ciudadResponse.getMensajes().add("Ciudades consultadas con éxito.");
		} 
		catch (QIUException qe) {
			
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(qe.getUserMesaage());
			qe.printStackTrace();
		} 
		catch (Exception e)
		{
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var userMessage = "Se ha presentado un problema consultando la información de las ciudades.";
			ciudadResponse.getMensajes().add(userMessage);
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(ciudadResponse, httpStatusCode);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CiudadResponse> modificar(@PathVariable UUID id, @RequestBody CiudadDTO ciudad)
	{
		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();
		
		try 
		{
			ciudad.setCodigo(id);
			// var facade = new ModificarCiudadFacade();
			//facade.execute(id);
			ciudadResponse.getMensajes().add("Ciudad eliminada con éxito.");
		} 
		catch (QIUException qe) {
			
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(qe.getUserMesaage());
			qe.printStackTrace();
		} 
		catch (Exception e)
		{
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var userMessage = "Se ha presentado un problema eliminando la información de la nueva ciudad.";
			ciudadResponse.getMensajes().add(userMessage);
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(ciudadResponse, httpStatusCode);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CiudadResponse> eliminar(@PathVariable UUID id)
	{
		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();
		
		try 
		{
			// var facade = new EliminarCiudadFacade();
			//facade.execute(id);
			ciudadResponse.getMensajes().add("Ciudades eliminada con éxito.");
		} 
		catch (QIUException qe) {
			
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(qe.getUserMesaage());
			qe.printStackTrace();
		} 
		catch (Exception e)
		{
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var userMessage = "Se ha presentado un problema eliminando la información de la nueva ciudad.";
			ciudadResponse.getMensajes().add(userMessage);
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(ciudadResponse, httpStatusCode);
	}
}
