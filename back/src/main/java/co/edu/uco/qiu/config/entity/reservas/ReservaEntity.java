package co.edu.uco.qiu.config.entity.reservas;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.entity.CoreEntity;
import co.edu.uco.qiu.config.entity.availability.DisponibilidadEntity;
import co.edu.uco.qiu.config.entity.personas.UsuarioEntity;

public final class ReservaEntity extends CoreEntity {
	
	private UsuarioEntity cliente;
	private DisponibilidadEntity disponibilidad;
	private TipoReservaEntity tipo;
	private EstadoReservaEntity estado;
	
	public ReservaEntity()
	{
		super();
	}
	
	public ReservaEntity(
			
			UUID codigo,
			UsuarioEntity cliente,
			DisponibilidadEntity disponibilidad,
			TipoReservaEntity tipo,
			EstadoReservaEntity estado
			
	)
	{
		setCodigo(codigo);
		setCliente(cliente);
		setDisponibilidad(disponibilidad);
		setTipo(tipo);
		setEstado(estado);
	}
	
	// Setters
	
	public final ReservaEntity setCliente( UsuarioEntity cliente )
	{
		ExceptionHandler.checkDtoNullParameter(cliente);
		
		this.cliente = cliente;
		return this;
	}
	
	public final ReservaEntity setDisponibilidad( DisponibilidadEntity disponibilidad )
	{
		ExceptionHandler.checkDtoNullParameter(disponibilidad);
		
		this.disponibilidad = disponibilidad;
		return this;
	}
	
	public final ReservaEntity setTipo( TipoReservaEntity tipo )
	{
		ExceptionHandler.checkDtoNullParameter(tipo);
		
		this.tipo = tipo;
		return this;
	}
	
	public ReservaEntity setEstado( EstadoReservaEntity estado )
	{
		ExceptionHandler.checkDtoNullParameter(estado);
		
		this.estado = estado;
		return this;
	}
	
	// Getters
	
	public final UsuarioEntity getCliente() {return this.cliente;}
	
	public final DisponibilidadEntity getDisponibilidad() {return this.disponibilidad;}
	
	public final TipoReservaEntity getTipo() {return this.tipo;}
	
	public final EstadoReservaEntity getEstado() {return this.estado;}
}
