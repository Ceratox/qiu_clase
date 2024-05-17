package co.edu.uco.qiu.config.entity.personas;

import java.util.Date;
import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.exceptions.custom.DtoQIUException;
import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.entity.CoreEntity;

public final class UsuarioEntity extends CoreEntity {
	
	private TipoUsuarioEntity tipo;
	private TipoIdUsuarioEntity tipoId;
	private int identificacion;
	private String nombre;
	private String direccion;
	private int telefono;
	private String email;
	
	private Date fechaRegistro;
	private boolean verificado;
	
	private String nombreUsuario;
	private String contrasena;
	
	private UsuarioEntity jefe;

	public UsuarioEntity()
	{
		super();
	}
	
	public UsuarioEntity( 
			
		UUID codigo, 
		
		TipoUsuarioEntity tipo, 
		
		TipoIdUsuarioEntity tipoId, 
		int identificacion, 
		String nombre, 
		String direccion,
		int telefono,
		String email, 
		
		Date fechaRegistro, 
		boolean verifiedStatus,
		
		String usernombre, 
		String contrasena,
		
		UsuarioEntity jefe
			
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

	public final UsuarioEntity setTipo( TipoUsuarioEntity tipo )
	{
		ExceptionHandler.checkDtoNullParameter(tipo);
		
		this.tipo = tipo;
		return this;
	}
	
	public final UsuarioEntity setTipoId( TipoIdUsuarioEntity tipoId )
	{
		ExceptionHandler.checkDtoNullParameter(tipoId);
		
		this.tipoId = tipoId;
		return this;
	}
	
	public final UsuarioEntity setId( int id )
	{
		if (id == 0)
		{
			throw new DtoQIUException("Automatically set user identificacion to 0. Sent identificacion was either negative or null.", "Automatically set user identificacion to 0. Sent identificacion was either negative or null.", null);
		}
		
		this.identificacion = id;
		return this;
	}
	
	public final UsuarioEntity setNombre( String nombre )
	{
		ExceptionHandler.checkDtoNullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	public final UsuarioEntity setDireccion( String direccion )
	{
		ExceptionHandler.checkDtoNullParameter(direccion);
		
		this.direccion = StringTool.applyTrim(direccion);
		return this;
	}
	
	public final UsuarioEntity setTelefono( int telefono )
	{
		ExceptionHandler.checkDtoNullParameter(telefono);
		
		this.telefono = telefono;
		return this;
	}
	
	public final UsuarioEntity setEmail( String email )
	{
		ExceptionHandler.checkDtoNullParameter(email);
		
		this.email = StringTool.applyTrim(email);
		return this;
	}
	
	public final UsuarioEntity setFechaRegistro( Date fecha )
	{
		ExceptionHandler.checkDtoNullParameter(fecha);
		
		this.fechaRegistro = fecha;
		return this;
	}
	
	public final UsuarioEntity setVerificado( boolean estado )
	{
		this.verificado = estado;
		return this;
	}
	
	public final UsuarioEntity setNombreUsuario( String nombre )
	{
		ExceptionHandler.checkDtoNullParameter(nombre);
		
		this.nombreUsuario = StringTool.applyTrim(nombre);
		return this;
	}
	
	public final UsuarioEntity setContrasena( String contrasena )
	{
		ExceptionHandler.checkDtoNullParameter(contrasena);
		
		this.contrasena = StringTool.applyTrim(contrasena);
		return this;
	}
	
	public UsuarioEntity setjefe(UsuarioEntity jefe) {
		
		ExceptionHandler.checkDtoNullParameter(jefe);
		
		this.jefe = jefe;
		return this;
	}
	
	// Getters
	
	public final TipoUsuarioEntity getTipo() {return this.tipo;}
	
	public final TipoIdUsuarioEntity getTipoId() {return this.tipoId;}
	
	public final int getIdentificacion() {return this.identificacion;}
	
	public final String getNombre() {return this.nombre;}
	
	public final String getDireccion() {return this.direccion;}
	
	public final int getTelefono() {return this.telefono;}
	
	public final String getEmail() {return this.email;}
	
	public final Date getFechaRegistro() {return this.fechaRegistro;}
	
	public final boolean estaVerificado() {return this.verificado;}
	
	public final String getNombreUsuario() {return this.nombreUsuario;}
	
	public final String getContrasena() {return this.contrasena;}
	
	public UsuarioEntity getJefe() { return this.jefe; }
	
}
