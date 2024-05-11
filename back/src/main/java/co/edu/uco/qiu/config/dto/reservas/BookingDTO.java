package co.edu.uco.qiu.config.dto.reservas;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.dto.CoreDTO;
import co.edu.uco.qiu.config.dto.disponiblidad.DisponibilidadDTO;
import co.edu.uco.qiu.config.dto.personas.UsuarioDTO;

public final class BookingDTO extends CoreDTO {
	
	private UsuarioDTO cliente;
	private DisponibilidadDTO disponibilidad;
	private TipoReservaDTO tipo;
	private EstadoReservaDTO estado;
	
	public BookingDTO()
	{
		super();
	}
	
	public BookingDTO(
			
			UUID codigo,
			UsuarioDTO cliente,
			DisponibilidadDTO disponibilidad,
			TipoReservaDTO tipo,
			EstadoReservaDTO estado
			
	)
	{
		setCodigo(codigo);
		setCliente(cliente);
		setDisponibilidad(disponibilidad);
		setTipo(tipo);
		setEstado(estado);
	}
	
	// Setters
	
	public final BookingDTO setCliente( UsuarioDTO cliente )
	{
		ExceptionHandler.checkDtoNullParameter(cliente);
		
		this.cliente = cliente;
		return this;
	}
	
	public final BookingDTO setDisponibilidad( DisponibilidadDTO disponibilidad )
	{
		ExceptionHandler.checkDtoNullParameter(disponibilidad);
		
		this.disponibilidad = disponibilidad;
		return this;
	}
	
	public final BookingDTO setTipo( TipoReservaDTO tipo )
	{
		ExceptionHandler.checkDtoNullParameter(tipo);
		
		this.tipo = tipo;
		return this;
	}
	
	public BookingDTO setEstado( EstadoReservaDTO estado )
	{
		ExceptionHandler.checkDtoNullParameter(estado);
		
		this.estado = estado;
		return this;
	}
	
	// Getters
	
	public final UsuarioDTO getCliente() {return this.cliente;}
	
	public final DisponibilidadDTO getDisponibilidad() {return this.disponibilidad;}
	
	public final TipoReservaDTO getTipo() {return this.tipo;}
	
	public final EstadoReservaDTO getEstado() {return this.estado;}
}
