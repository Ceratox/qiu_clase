package co.edu.uco.qiu.config.dto.personas;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.dto.CoreDTO;

public final class TipoUsuarioDTO extends CoreDTO {
	
	private String nombre;
	
	public TipoUsuarioDTO()
	{
		super();
	}
	
	public TipoUsuarioDTO( UUID newCodigo, String newNombre )
	{
		setCodigo(newCodigo);
		setNombre(newNombre);
	}
	
	// Setters 
	
	public final TipoUsuarioDTO setNombre( String newNombre )
	{
		ExceptionHandler.checkDtoNullParameter(newNombre);
		
		this.nombre = StringTool.applyTrim(newNombre);
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}

}
