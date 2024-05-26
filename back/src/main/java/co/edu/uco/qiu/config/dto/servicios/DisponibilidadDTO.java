package co.edu.uco.qiu.config.dto.servicios;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.dto.CoreDTO;
import co.edu.uco.qiu.config.dto.organizaciones.ModuloDTO;
import co.edu.uco.qiu.config.dto.personas.UsuarioDTO;

public final class DisponibilidadDTO extends CoreDTO {
	
	private UsuarioDTO trabajador;
	private ModuloDTO modulo;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	
	public DisponibilidadDTO()
	{
		super();
	}
	
	public DisponibilidadDTO(
			
			UUID code,
			UsuarioDTO trabajador,
			ModuloDTO modulo,
			LocalDate fecha,
			LocalTime horaInicio,
			LocalTime horaFin
			
	)
	{
		setCodigo(code);
		setTrabajador(trabajador);
		setModulo(modulo);
		setFecha(fecha);
		setHoraInicio(horaInicio);
		setHoraFin(horaFin);
	}
	
	// Setters
	
	public final DisponibilidadDTO setTrabajador( UsuarioDTO trabajador )
	{
		ExceptionHandler.checkDTONullParameter(trabajador);
		
		this.trabajador = trabajador;
		return this;
	}
	
	public final DisponibilidadDTO setModulo( ModuloDTO modulo )
	{
		ExceptionHandler.checkDTONullParameter(modulo);
		
		this.modulo = modulo;
		return this;
	}
	
	public final DisponibilidadDTO setFecha( LocalDate fecha )
	{
		ExceptionHandler.checkDTONullParameter(fecha);
		
		this.fecha = fecha;
		return this;
	}
	
	public final DisponibilidadDTO setHoraInicio( LocalTime hora )
	{
		ExceptionHandler.checkDTONullParameter(hora);
		
		this.horaInicio = hora;
		return this;
	}
	
	public final DisponibilidadDTO setHoraFin( LocalTime hora )
	{
		ExceptionHandler.checkDTONullParameter(hora);
		
		this.horaFin = hora;
		return this;
	}
	
	// Getters
	
	public final UsuarioDTO getTrabajador() {return this.trabajador;}
	
	public final ModuloDTO getModulo() {return this.modulo;}
	
	public final LocalDate getFecha() {return this.fecha;}
	
	public final LocalTime getHoraInicio() {return this.horaInicio;}
	
	public final LocalTime getHoraFin() {return this.horaFin;}

}
