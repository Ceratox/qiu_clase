package co.edu.uco.qiu.config.business.domain.localizacion;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.crosscutting.helpers.UUIDHelper;

public final class CiudadDomain {

	private UUID codigo;
	private String nombre;
	private DepartamentoDomain departamento;
	
	private CiudadDomain(final UUID codigo, final String nombre, final DepartamentoDomain departamento)
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDepartamento(departamento);
	}
	
	public static final CiudadDomain build(final UUID codigo, final String nombre, final DepartamentoDomain departamento)
	{
		return new CiudadDomain(codigo, nombre, departamento);
	}
	
	public static final CiudadDomain build(final UUID codigo, final String nombre)
	{
		return new CiudadDomain(codigo, nombre, DepartamentoDomain.build());
	}
	
	public static final CiudadDomain build(final UUID codigo)
	{
		return new CiudadDomain(codigo, StringTool.EMPTY, DepartamentoDomain.build());
	}
	
	public static final CiudadDomain build()
	{
		return new CiudadDomain(UUIDHelper.getDefault(), StringTool.EMPTY, DepartamentoDomain.build());
	}
	
	// Setters 
	
	private void setCodigo(final UUID codigo) {
		this.codigo = UUIDHelper.getDefault(codigo, UUIDHelper.getDefault());
	}
	
	private void setNombre(final String nombre) {
		this.nombre = StringTool.applyTrim(nombre);
	}
	
	private void setDepartamento(DepartamentoDomain departamento) {
		this.departamento = ObjectHelper.getObjectHelper().getDefaultValue(departamento, DepartamentoDomain.build());
	}
	
	// Getters
	
	public final UUID getCodigo() {
		return codigo;
	}
	
	public final String getNombre() {
		return nombre;
	}

	public final DepartamentoDomain getDepartamento() {
		return departamento;
	}
}
