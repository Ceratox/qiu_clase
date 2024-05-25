package co.edu.uco.qiu.config.controller.response;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {

	private List<String> mensajes = new ArrayList<String>();
	private List<T> datos;
	
	// Setters
	
	public void setMensajes(List<String> mensajes) {
		this.mensajes = mensajes;
	}
	
	public void setDatos(List<T> datos) {
		this.datos = datos;
	}
	
	// Getters
	
	public List<String> getMensajes() {
		return mensajes;
	}
	
	public List<T> getDatos() {
		return datos;
	}
}
