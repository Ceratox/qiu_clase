package co.edu.uco.qiu.config.dto.organizaciones;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.dto.CoreDTO;

public final class ModuloDTO extends CoreDTO {
	
	private SedeDTO sede;
	private TipoModuloDTO tipo;
	private String indicativo;
	
	public ModuloDTO()
	{
		super();
	}
	
	public ModuloDTO(
			
			UUID codigo,
			SedeDTO sede,
			TipoModuloDTO tipo,
			String indicativo
			
	)
	{
		setCodigo(codigo);
		setSede(sede);
		setTipo(tipo);
		setIndicativo(indicativo);
	}
	
	// Setters
	
	public final ModuloDTO setSede( SedeDTO sede )
	{
		ExceptionHandler.checkDTONullParameter(sede);
		
		this.sede = sede;
		return this;
	}
	
	public final ModuloDTO setTipo( TipoModuloDTO tipo )
	{
		ExceptionHandler.checkDTONullParameter(tipo);
		
		this.tipo = tipo;
		return this;
	}
	
	public final ModuloDTO setIndicativo( String indicativo )
	{
		ExceptionHandler.checkDTONullParameter(indicativo);
		
		this.indicativo = StringTool.applyTrim(indicativo);
		return this;
	}
	
	// Getters
	
	public final SedeDTO getSede() {return this.sede;}
	
	public final TipoModuloDTO getTipo() {return this.tipo;}
	
	public final String getIndicativo() {return this.indicativo;}
	
}
