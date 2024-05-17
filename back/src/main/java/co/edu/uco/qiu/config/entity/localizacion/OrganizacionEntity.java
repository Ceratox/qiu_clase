package co.edu.uco.qiu.config.entity.localizacion;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.entity.CoreEntity;
import co.edu.uco.qiu.config.entity.personas.UsuarioEntity;

public final class OrganizacionEntity extends CoreEntity {

	private TipoIdOrganizacionEntity tipoId;
	private int identificacion;
	private String nombre;
	private String descripcion;
	private UsuarioEntity administrador;
	
	private boolean verificada;
	
	public OrganizacionEntity()
	{
		super();
	}
	
	public OrganizacionEntity(
			
			UUID codigo,
			TipoIdOrganizacionEntity tipoId,
			int identificacion,
			String nombre,
			String descripcion,
			UsuarioEntity administrador,
			boolean verificada
			
	)
	{
		setCodigo(codigo);
		setTipoId(tipoId);
		setIdentificacion(identificacion);
		setNombre(nombre);
		setDescripcion(descripcion);
		setAdministrador(administrador);
		setVerificada(verificada);
	}
	
	// Setters
	
	public final OrganizacionEntity setTipoId( TipoIdOrganizacionEntity tipoId )
	{
		ExceptionHandler.checkDtoNullParameter(tipoId);
		
		this.tipoId = tipoId;
		return this;
	}
	
	public final OrganizacionEntity setIdentificacion( int identificacion )
	{
		this.identificacion = identificacion;
		return this;
	}
	
	public final OrganizacionEntity setNombre( String nombre )
	{
		ExceptionHandler.checkDtoNullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	public final OrganizacionEntity setDescripcion( String descripcion )
	{
		ExceptionHandler.checkDtoNullParameter(descripcion);
		
		this.descripcion = StringTool.applyTrim(descripcion);
		return this;
	}
	
	public final OrganizacionEntity setAdministrador( UsuarioEntity administrador )
	{
		ExceptionHandler.checkDtoNullParameter(administrador);
		
		this.administrador = administrador;
		return this;
	}
	
	public final OrganizacionEntity setVerificada( boolean verificada )
	{
		this.verificada = verificada;
		return this;
	}
	
	// Getters
	
	public final TipoIdOrganizacionEntity getTipoId() {return this.tipoId;}
	
	public final int getIdentificacion() {return this.identificacion;}
	
	public final String getNombre() {return this.nombre;}
	
	public final String getDescripcion() {return this.descripcion;}
	
	public final UsuarioEntity getAdministrador() {return this.administrador;}
	
	public final boolean estaVerificada() {return this.verificada;}
}
