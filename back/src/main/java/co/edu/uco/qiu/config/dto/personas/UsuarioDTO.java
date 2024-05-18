package co.edu.uco.qiu.config.dto.personas;

import java.util.Date;
import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.exceptions.custom.DtoQIUException;
import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.dto.CoreDTO;

public final class UsuarioDTO extends CoreDTO {
	
	private TipoUsuarioDTO tipo;
	private TipoIdUsuarioDTO tipoId;
	private int identificacion;
	private String nombre;
	private String direccion;
	private int telefono;
	private String email;
	
	private Date fechaRegistro;
	private boolean verificado;
	
	private String nombreUsuario;
	private String contrasena;
	
	private UsuarioDTO jefe;

	public UsuarioDTO()
	{
		super();
	}
	
	public UsuarioDTO( 
			
		UUID codigo, 
		
		TipoUsuarioDTO tipo, 
		
		TipoIdUsuarioDTO tipoId, 
		int identificacion, 
		String nombre, 
		String direccion,
		int telefono,
		String email, 
		
		Date fechaRegistro, 
		boolean verifiedStatus,
		
		String usernombre, 
		String contrasena,
		
		UsuarioDTO jefe
			
	)
	{
		setCodigo(codigo);
		setTipo(tipo);
		setTipoId(tipoId);
		setId( identificacion < 0 ? 0 : identificacion );
		setNombre(nombre);
		setDireccion(direccion);
		setTelefono(telefono);
		setEmail(email);
		setFechaRegistro(fechaRegistro);
		setVerificado(verifiedStatus);
		setNombreUsuario(usernombre);
		setContrasena(contrasena);
		setjefe(jefe);
	}
	
	// Setters

	public final UsuarioDTO setTipo( TipoUsuarioDTO tipo )
	{
		ExceptionHandler.checkDTONullParameter(tipo);
		
		this.tipo = tipo;
		return this;
	}
	
	public final UsuarioDTO setTipoId( TipoIdUsuarioDTO tipoId )
	{
		ExceptionHandler.checkDTONullParameter(tipoId);
		
		this.tipoId = tipoId;
		return this;
	}
	
	public final UsuarioDTO setId( int id )
	{
		if (id == 0)
		{
			throw new DtoQIUException("Automatically set user identificacion to 0. Sent identificacion was either negative or null.", "Automatically set user identificacion to 0. Sent identificacion was either negative or null.", null);
		}
		
		this.identificacion = id;
		return this;
	}
	
	public final UsuarioDTO setNombre( String nombre )
	{
		ExceptionHandler.checkDTONullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	public final UsuarioDTO setDireccion( String direccion )
	{
		ExceptionHandler.checkDTONullParameter(direccion);
		
		this.direccion = StringTool.applyTrim(direccion);
		return this;
	}
	
	public final UsuarioDTO setTelefono( int telefono )
	{
		ExceptionHandler.checkDTONullParameter(telefono);
		
		this.telefono = telefono;
		return this;
	}
	
	public final UsuarioDTO setEmail( String email )
	{
		ExceptionHandler.checkDTONullParameter(email);
		
		this.email = StringTool.applyTrim(email);
		return this;
	}
	
	public final UsuarioDTO setFechaRegistro( Date fecha )
	{
		ExceptionHandler.checkDTONullParameter(fecha);
		
		this.fechaRegistro = fecha;
		return this;
	}
	
	public final UsuarioDTO setVerificado( boolean estado )
	{
		this.verificado = estado;
		return this;
	}
	
	public final UsuarioDTO setNombreUsuario( String nombre )
	{
		ExceptionHandler.checkDTONullParameter(nombre);
		
		this.nombreUsuario = StringTool.applyTrim(nombre);
		return this;
	}
	
	public final UsuarioDTO setContrasena( String contrasena )
	{
		ExceptionHandler.checkDTONullParameter(contrasena);
		
		this.contrasena = StringTool.applyTrim(contrasena);
		return this;
	}
	
	public UsuarioDTO setjefe(UsuarioDTO jefe) {
		
		ExceptionHandler.checkDTONullParameter(jefe);
		
		this.jefe = jefe;
		return this;
	}
	
	// Getters
	
	public final TipoUsuarioDTO getTipo() {return this.tipo;}
	
	public final TipoIdUsuarioDTO getTipoId() {return this.tipoId;}
	
	public final int getIdentificacion() {return this.identificacion;}
	
	public final String getNombre() {return this.nombre;}
	
	public final String getDireccion() {return this.direccion;}
	
	public final int getTelefono() {return this.telefono;}
	
	public final String getEmail() {return this.email;}
	
	public final Date getFechaRegistro() {return this.fechaRegistro;}
	
	public final boolean estaVerificado() {return this.verificado;}
	
	public final String getNombreUsuario() {return this.nombreUsuario;}
	
	public final String getContrasena() {return this.contrasena;}
	
	public UsuarioDTO getJefe() { return this.jefe; }
	
}
