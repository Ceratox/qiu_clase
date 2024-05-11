package co.edu.uco.qiu.config.dto.personas;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.dto.CoreDTO;

public final class TipoIdUsuarioDTO extends CoreDTO {
	
	private String nombre;
	
	public TipoIdUsuarioDTO()
	{
		super();
	}
	
	public TipoIdUsuarioDTO( UUID newCodigo, String newNombre )
	{
		setCodigo(newCodigo);
		setNombre(newNombre);
	}
	
	// Setters 
	
	public final TipoIdUsuarioDTO setNombre( String newNombre )
	{
		ExceptionHandler.checkDtoNullParameter(newNombre);
		
		this.nombre = StringTool.applyTrim(newNombre);
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}

}
