package co.edu.uco.qiu.config.dto.location;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.dto.CoreDTO;
import co.edu.uco.qiu.config.dto.personas.UsuarioDTO;

public final class OrganizacionDTO extends CoreDTO {

	private TipoIdOrganizacionDTO tipoId;
	private int identificacion;
	private String nombre;
	private String descripcion;
	private UsuarioDTO administrador;
	
	private boolean verificada;
	
	public OrganizacionDTO()
	{
		super();
	}
	
	public OrganizacionDTO(
			
			UUID codigo,
			TipoIdOrganizacionDTO tipoId,
			int identificacion,
			String nombre,
			String descripcion,
			UsuarioDTO administrador,
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
	
	public final OrganizacionDTO setTipoId( TipoIdOrganizacionDTO tipoId )
	{
		ExceptionHandler.checkDtoNullParameter(tipoId);
		
		this.tipoId = tipoId;
		return this;
	}
	
	public final OrganizacionDTO setIdentificacion( int identificacion )
	{
		this.identificacion = identificacion;
		return this;
	}
	
	public final OrganizacionDTO setNombre( String nombre )
	{
		ExceptionHandler.checkDtoNullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	public final OrganizacionDTO setDescripcion( String descripcion )
	{
		ExceptionHandler.checkDtoNullParameter(descripcion);
		
		this.descripcion = StringTool.applyTrim(descripcion);
		return this;
	}
	
	public final OrganizacionDTO setAdministrador( UsuarioDTO administrador )
	{
		ExceptionHandler.checkDtoNullParameter(administrador);
		
		this.administrador = administrador;
		return this;
	}
	
	public final OrganizacionDTO setVerificada( boolean verificada )
	{
		this.verificada = verificada;
		return this;
	}
	
	// Getters
	
	public final TipoIdOrganizacionDTO getTipoId() {return this.tipoId;}
	
	public final int getIdentificacion() {return this.identificacion;}
	
	public final String getNombre() {return this.nombre;}
	
	public final String getDescripcion() {return this.descripcion;}
	
	public final UsuarioDTO getAdministrador() {return this.administrador;}
	
	public final boolean estaVerificada() {return this.verificada;}
}
