package co.edu.uco.qiu.config.dto.reservas;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.dto.CoreDTO;

public final class TipoReservaDTO extends CoreDTO {
	
	private String nombre;
	
	public TipoReservaDTO()
	{
		super();
	}
	
	public TipoReservaDTO( UUID codigo, String nombre )
	{
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	// Setters 
	
	public final TipoReservaDTO setNombre( String nombre )
	{
		ExceptionHandler.checkDtoNullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}

}
