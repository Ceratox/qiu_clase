package co.edu.uco.qiu.config.dto.organizaciones;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.dto.CoreDTO;
import co.edu.uco.qiu.config.dto.personas.UsuarioDTO;

public final class SedeDTO extends CoreDTO {
	
	private OrganizacionDTO organizacion;
	private String nombre;
	private CiudadDTO ciudad;
	private String direccion;
	private int telefono;
	private String email;
	private UsuarioDTO administrador;
	
	public SedeDTO()
	{
		super();
	}
	
	public SedeDTO(
			
			UUID codigo,
			OrganizacionDTO organizacion,
			String nombre,
			CiudadDTO ciudad,
			String direccion,
			int telefono,
			String email,
			UsuarioDTO administrador
			
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
	
	public final SedeDTO setOrganizacion( OrganizacionDTO organizacion )
	{
		ExceptionHandler.checkDTONullParameter(organizacion);
		
		this.organizacion = organizacion;
		return this;
	}
	
	public final SedeDTO setNombre( String nombre )
	{
		ExceptionHandler.checkDTONullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	public final SedeDTO setCiudad( CiudadDTO ciudad )
	{
		ExceptionHandler.checkDTONullParameter(ciudad);
		
		this.ciudad = ciudad;
		return this;
	}
	
	public final SedeDTO setDireccion( String direccion )
	{
		ExceptionHandler.checkDTONullParameter(direccion);
		
		this.direccion = StringTool.applyTrim(direccion);
		return this;
	}
	
	public final SedeDTO setTelefono( int telefono )
	{
		ExceptionHandler.checkDTONullParameter(telefono);
		
		this.telefono = telefono;
		return this;
	}
	
	public final SedeDTO setEmail( String email )
	{
		ExceptionHandler.checkDTONullParameter(email);
		
		this.email = StringTool.applyTrim(email);
		return this;
	}
	
	public final SedeDTO setAdministrador( UsuarioDTO administrador )
	{
		ExceptionHandler.checkDTONullParameter(administrador);
		
		this.administrador = administrador;
		return this;
	}
	
	// Getters
	
	public final OrganizacionDTO getOrganizacion() {return this.organizacion;}
	
	public final String getNombre() {return this.nombre;}
	
	public final CiudadDTO getCiudad() {return this.ciudad;}
	
	public final String getDireccion() {return this.direccion;}
	
	public final int getTelefono() {return this.telefono;}
	
	public final String getEmail() {return this.email;}
	
	public final UsuarioDTO getAdministrador() {return this.administrador;}

}
