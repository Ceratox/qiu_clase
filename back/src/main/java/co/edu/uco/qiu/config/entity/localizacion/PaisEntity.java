package co.edu.uco.qiu.config.entity.localizacion;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.crosscutting.helpers.UUIDHelper;
import co.edu.uco.qiu.config.entity.CoreEntity;

public final class PaisEntity extends CoreEntity {
	
	private String nombre;
	
	public PaisEntity()
	{
		super();
		setCodigo( UUIDHelper.getDefault() );
		setNombre( StringTool.EMPTY );
	}
	
	public PaisEntity( final UUID codigo, final String nombre )
	{
		setCodigo( codigo );
		setNombre( nombre );
	}
	
	// Setters
	
	public final PaisEntity setNombre( String nombre )
	{
		ExceptionHandler.checkDTONullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}

}
