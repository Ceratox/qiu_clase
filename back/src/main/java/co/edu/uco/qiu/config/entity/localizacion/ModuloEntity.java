package co.edu.uco.qiu.config.entity.localizacion;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.entity.CoreEntity;

public final class ModuloEntity extends CoreEntity {
	
	private SedeEntity sede;
	private TipoModuloEntity tipo;
	private String indicativo;
	
	public ModuloEntity()
	{
		super();
	}
	
	public ModuloEntity(
			
			UUID codigo,
			SedeEntity sede,
			TipoModuloEntity tipo,
			String indicativo
			
	)
	{
		setCodigo(codigo);
		setSede(sede);
		setTipo(tipo);
		setIndicativo(indicativo);
	}
	
	// Setters
	
	public final ModuloEntity setSede( SedeEntity sede )
	{
		ExceptionHandler.checkDTONullParameter(sede);
		
		this.sede = sede;
		return this;
	}
	
	public final ModuloEntity setTipo( TipoModuloEntity tipo )
	{
		ExceptionHandler.checkDTONullParameter(tipo);
		
		this.tipo = tipo;
		return this;
	}
	
	public final ModuloEntity setIndicativo( String indicativo )
	{
		ExceptionHandler.checkDTONullParameter(indicativo);
		
		this.indicativo = StringTool.applyTrim(indicativo);
		return this;
	}
	
	// Getters
	
	public final SedeEntity getSede() {return this.sede;}
	
	public final TipoModuloEntity getTipo() {return this.tipo;}
	
	public final String getIndicativo() {return this.indicativo;}
	
}
