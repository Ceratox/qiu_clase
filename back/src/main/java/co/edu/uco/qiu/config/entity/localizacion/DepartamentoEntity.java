package co.edu.uco.qiu.config.entity.localizacion;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.dto.CoreDTO;

public final class DepartamentoEntity extends CoreDTO {

	private String nombre;
	private PaisEntity pais;
	
	public DepartamentoEntity()
	{
		super();
	}
	
	public DepartamentoEntity( UUID codigo, String nombre, PaisEntity pais )
	{
		setCodigo( codigo );
		setNombre( nombre );
		setPais( pais );
	}
	
	// Setters
	
	public final DepartamentoEntity setNombre( String nombre )
	{
		ExceptionHandler.checkDtoNullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	public final DepartamentoEntity setPais( PaisEntity pais )
	{
		ExceptionHandler.checkDtoNullParameter(pais);
		
		this.pais = pais;
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}
	
	public final PaisEntity getPais() {return this.pais;}
	
}
