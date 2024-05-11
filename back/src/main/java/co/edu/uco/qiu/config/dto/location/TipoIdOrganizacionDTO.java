package co.edu.uco.qiu.config.dto.location;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.dto.CoreDTO;

public final class TipoIdOrganizacionDTO extends CoreDTO {

	private String nombre;
	
	public TipoIdOrganizacionDTO()
	{
		super();
	}
	
	public TipoIdOrganizacionDTO( UUID newCode, String nombre )
	{
		setCodigo(newCode);
		setNombre(nombre);
	}
	
	// Setters 
	
	public final TipoIdOrganizacionDTO setNombre( String nombre )
	{
		ExceptionHandler.checkDtoNullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}
}
