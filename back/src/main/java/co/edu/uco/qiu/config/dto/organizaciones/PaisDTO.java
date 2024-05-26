package co.edu.uco.qiu.config.dto.organizaciones;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.crosscutting.helpers.UUIDHelper;
import co.edu.uco.qiu.config.dto.CoreDTO;

public final class PaisDTO extends CoreDTO {
	
	private String nombre;
	
	public PaisDTO()
	{
		super();
		setCodigo(UUIDHelper.getDefault());
		setNombre( StringTool.EMPTY );
	}
	
	public PaisDTO( final UUID codigo, final String nombre )
	{
		setCodigo( codigo );
		setNombre( nombre );
	}
	
	// Setters
	
	public final PaisDTO setNombre( String nombre )
	{
		ExceptionHandler.checkDTONullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}

}
