package co.edu.uco.qiu.config.entity.localizacion;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.entity.CoreEntity;

public final class TipoIdOrganizacionEntity extends CoreEntity {

	private String nombre;
	
	public TipoIdOrganizacionEntity()
	{
		super();
	}
	
	public TipoIdOrganizacionEntity( UUID newCode, String nombre )
	{
		setCodigo(newCode);
		setNombre(nombre);
	}
	
	// Setters 
	
	public final TipoIdOrganizacionEntity setNombre( String nombre )
	{
		ExceptionHandler.checkDTONullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}
}
