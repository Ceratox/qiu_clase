package co.edu.uco.qiu.config.entity.localizacion;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.entity.CoreEntity;

public final class TipoModuloEntity extends CoreEntity {
	
	private String nombre;
	
	public TipoModuloEntity()
	{
		super();
	}
	
	public TipoModuloEntity( UUID codigo, String nombre )
	{
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	// Setters 
	
	public final TipoModuloEntity setNombre( String nombre )
	{
		ExceptionHandler.checkDTONullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}

}
