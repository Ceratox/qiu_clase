package co.edu.uco.qiu.config.entity.personas;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.entity.CoreEntity;

public final class TipoIdUsuarioEntity extends CoreEntity {
	
	private String nombre;
	
	public TipoIdUsuarioEntity()
	{
		super();
	}
	
	public TipoIdUsuarioEntity( UUID newCodigo, String newNombre )
	{
		setCodigo(newCodigo);
		setNombre(newNombre);
	}
	
	// Setters 
	
	public final TipoIdUsuarioEntity setNombre( String newNombre )
	{
		ExceptionHandler.checkDTONullParameter(newNombre);
		
		this.nombre = StringTool.applyTrim(newNombre);
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}

}
