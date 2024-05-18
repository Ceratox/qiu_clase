package co.edu.uco.qiu.config.dto.localizacion;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.dto.CoreDTO;

public final class DepartamentoDTO extends CoreDTO {

	private String nombre;
	private PaisEntity pais;
	
	public DepartamentoDTO()
	{
		super();
	}
	
	public DepartamentoDTO( UUID code, String name, PaisEntity country )
	{
		setCodigo( code );
		setNombre( name );
		setPais( country );
	}
	
	// Setters
	
	public final DepartamentoDTO setNombre( String nombre )
	{
		ExceptionHandler.checkDTONullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	public final DepartamentoDTO setPais( PaisEntity pais )
	{
		ExceptionHandler.checkDTONullParameter(pais);
		
		this.pais = pais;
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}
	
	public final PaisEntity getPais() {return this.pais;}
	
}
