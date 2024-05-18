package co.edu.uco.qiu.config.dto.localizacion;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.dto.CoreDTO;

public final class TipoSedeDTO extends CoreDTO {
	
	private String nombre;
	
	public TipoSedeDTO()
	{
		super();
	}
	
	public TipoSedeDTO( UUID codigo, String nombre )
	{
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	// Setters 
	
	public final TipoSedeDTO setNombre( String nombre )
	{
		ExceptionHandler.checkDTONullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}

}
