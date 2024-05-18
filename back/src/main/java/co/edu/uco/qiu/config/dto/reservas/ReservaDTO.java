package co.edu.uco.qiu.config.dto.reservas;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.dto.CoreDTO;
import co.edu.uco.qiu.config.dto.disponiblidad.DisponibilidadDTO;
import co.edu.uco.qiu.config.dto.personas.UsuarioDTO;

public final class ReservaDTO extends CoreDTO {
	
	private UsuarioDTO cliente;
	private DisponibilidadDTO disponibilidad;
	private TipoReservaDTO tipo;
	private EstadoReservaDTO estado;
	
	public ReservaDTO()
	{
		super();
	}
	
	public ReservaDTO(
			
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
	
	public final ReservaDTO setCliente( UsuarioDTO cliente )
	{
		ExceptionHandler.checkDTONullParameter(cliente);
		
		this.cliente = cliente;
		return this;
	}
	
	public final ReservaDTO setDisponibilidad( DisponibilidadDTO disponibilidad )
	{
		ExceptionHandler.checkDTONullParameter(disponibilidad);
		
		this.disponibilidad = disponibilidad;
		return this;
	}
	
	public final ReservaDTO setTipo( TipoReservaDTO tipo )
	{
		ExceptionHandler.checkDTONullParameter(tipo);
		
		this.tipo = tipo;
		return this;
	}
	
	public ReservaDTO setEstado( EstadoReservaDTO estado )
	{
		ExceptionHandler.checkDTONullParameter(estado);
		
		this.estado = estado;
		return this;
	}
	
	// Getters
	
	public final UsuarioDTO getCliente() {return this.cliente;}
	
	public final DisponibilidadDTO getDisponibilidad() {return this.disponibilidad;}
	
	public final TipoReservaDTO getTipo() {return this.tipo;}
	
	public final EstadoReservaDTO getEstado() {return this.estado;}
}
