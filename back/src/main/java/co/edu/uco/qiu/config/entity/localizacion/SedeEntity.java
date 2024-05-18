package co.edu.uco.qiu.config.entity.localizacion;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.entity.CoreEntity;
import co.edu.uco.qiu.config.entity.personas.UsuarioEntity;

public final class SedeEntity extends CoreEntity {
	
	private OrganizacionEntity organizacion;
	private String nombre;
	private CiudadEntity ciudad;
	private String direccion;
	private int telefono;
	private String email;
	private UsuarioEntity administrador;
	
	public SedeEntity()
	{
		super();
	}
	
	public SedeEntity(
			
			UUID codigo,
			OrganizacionEntity organizacion,
			String nombre,
			CiudadEntity ciudad,
			String direccion,
			int telefono,
			String email,
			UsuarioEntity administrador
			
	)
	{
		setCodigo(codigo);
		setOrganizacion(organizacion);
		setNombre(nombre);
		setCiudad(ciudad);
		setDireccion(direccion);
		setTelefono(telefono);
		setEmail(email);
		setAdministrador(administrador);
	}
	
	// Setters
	
	public final SedeEntity setOrganizacion( OrganizacionEntity organizacion )
	{
		ExceptionHandler.checkDTONullParameter(organizacion);
		
		this.organizacion = organizacion;
		return this;
	}
	
	public final SedeEntity setNombre( String nombre )
	{
		ExceptionHandler.checkDTONullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	public final SedeEntity setCiudad( CiudadEntity ciudad )
	{
		ExceptionHandler.checkDTONullParameter(ciudad);
		
		this.ciudad = ciudad;
		return this;
	}
	
	public final SedeEntity setDireccion( String direccion )
	{
		ExceptionHandler.checkDTONullParameter(direccion);
		
		this.direccion = StringTool.applyTrim(direccion);
		return this;
	}
	
	public final SedeEntity setTelefono( int telefono )
	{
		ExceptionHandler.checkDTONullParameter(telefono);
		
		this.telefono = telefono;
		return this;
	}
	
	public final SedeEntity setEmail( String email )
	{
		ExceptionHandler.checkDTONullParameter(email);
		
		this.email = StringTool.applyTrim(email);
		return this;
	}
	
	public final SedeEntity setAdministrador( UsuarioEntity administrador )
	{
		ExceptionHandler.checkDTONullParameter(administrador);
		
		this.administrador = administrador;
		return this;
	}
	
	// Getters
	
	public final OrganizacionEntity getOrganizacion() {return this.organizacion;}
	
	public final String getNombre() {return this.nombre;}
	
	public final CiudadEntity getCiudad() {return this.ciudad;}
	
	public final String getDireccion() {return this.direccion;}
	
	public final int getTelefono() {return this.telefono;}
	
	public final String getEmail() {return this.email;}
	
	public final UsuarioEntity getAdministrador() {return this.administrador;}

}
