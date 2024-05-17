package co.edu.uco.qiu.config.entity.availability;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.entity.CoreEntity;
import co.edu.uco.qiu.config.entity.localizacion.ModuloEntity;
import co.edu.uco.qiu.config.entity.personas.UsuarioEntity;

public final class DisponibilidadEntity extends CoreEntity {
	
	private UsuarioEntity trabajador;
	private ModuloEntity modulo;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	
	public DisponibilidadEntity()
	{
		super();
	}
	
	public DisponibilidadEntity(
			
			UUID code,
			UsuarioEntity trabajador,
			ModuloEntity modulo,
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
	
	public final DisponibilidadEntity setTrabajador( UsuarioEntity trabajador )
	{
		ExceptionHandler.checkDtoNullParameter(trabajador);
		
		this.trabajador = trabajador;
		return this;
	}
	
	public final DisponibilidadEntity setModulo( ModuloEntity modulo )
	{
		ExceptionHandler.checkDtoNullParameter(modulo);
		
		this.modulo = modulo;
		return this;
	}
	
	public final DisponibilidadEntity setFecha( LocalDate fecha )
	{
		ExceptionHandler.checkDtoNullParameter(fecha);
		
		this.fecha = fecha;
		return this;
	}
	
	public final DisponibilidadEntity setHoraInicio( LocalTime hora )
	{
		ExceptionHandler.checkDtoNullParameter(hora);
		
		this.horaInicio = hora;
		return this;
	}
	
	public final DisponibilidadEntity setHoraFin( LocalTime hora )
	{
		ExceptionHandler.checkDtoNullParameter(hora);
		
		this.horaFin = hora;
		return this;
	}
	
	// Getters
	
	public final UsuarioEntity getTrabajador() {return this.trabajador;}
	
	public final ModuloEntity getModulo() {return this.modulo;}
	
	public final LocalDate getFecha() {return this.fecha;}
	
	public final LocalTime getHoraInicio() {return this.horaInicio;}
	
	public final LocalTime getHoraFin() {return this.horaFin;}

}
