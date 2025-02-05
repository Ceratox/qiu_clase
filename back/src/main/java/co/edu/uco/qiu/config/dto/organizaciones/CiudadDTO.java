package co.edu.uco.qiu.config.dto.organizaciones;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.crosscutting.helpers.UUIDHelper;
import co.edu.uco.qiu.config.dto.CoreDTO;

public final class CiudadDTO extends CoreDTO {
	
	private String nombre;
	private DepartamentoDTO departamento;
	
	public CiudadDTO()
	{
		super();
		setCodigo(UUIDHelper.getDefault());
		setNombre( StringTool.EMPTY );
		setDepartamento( new DepartamentoDTO() );
	}
	
	public CiudadDTO( UUID codigo, String nombre, DepartamentoDTO departamento )
	{
		setCodigo( codigo );
		setNombre( nombre );
		setDepartamento( departamento );
	}
	
	// Setters
	
	public final CiudadDTO setNombre( String nombre )
	{
		ExceptionHandler.checkDTONullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	public final CiudadDTO setDepartamento( DepartamentoDTO departamento )
	{
		ExceptionHandler.checkDTONullParameter(departamento);
		
		this.departamento = departamento;
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}
	
	public final DepartamentoDTO getDepartamento() {return this.departamento;}

}
