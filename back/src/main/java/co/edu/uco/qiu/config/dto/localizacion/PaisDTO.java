package co.edu.uco.qiu.config.dto.localizacion;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.dto.CoreDTO;

public final class PaisDTO extends CoreDTO {
	
	private String nombre;
	
	public PaisDTO()
	{
		super();
	}
	
	public PaisDTO( final UUID codigo, final String nombre )
	{
		setCodigo( codigo );
		setNombre( nombre );
	}
	
	// Setters
	
	public final PaisDTO setNombre( String nombre )
	{
		ExceptionHandler.checkDtoNullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}

}
