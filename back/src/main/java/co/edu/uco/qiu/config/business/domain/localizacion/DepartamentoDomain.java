package co.edu.uco.qiu.config.business.domain.localizacion;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.crosscutting.helpers.UUIDHelper;

public final class DepartamentoDomain {

	private UUID codigo;
	private String nombre;
	private PaisDomain pais;
	
	private DepartamentoDomain(final UUID codigo, final String nombre, final PaisDomain pais)
	{
		setCodigo(codigo);
		setNombre(nombre);
		setPais(pais);
	}
	
	public static final DepartamentoDomain build(final UUID codigo, final String nombre, final PaisDomain pais)
	{
		return new DepartamentoDomain(codigo, nombre, pais);
	}
	
	public static final DepartamentoDomain build(final UUID codigo, final String nombre)
	{
		return new DepartamentoDomain(codigo, nombre, PaisDomain.build());
	}
	
	public static final DepartamentoDomain build(final UUID codigo)
	{
		return new DepartamentoDomain(codigo, StringTool.EMPTY, PaisDomain.build());
	}
	
	public static final DepartamentoDomain build()
	{
		return new DepartamentoDomain(UUIDHelper.getDefault(), StringTool.EMPTY, PaisDomain.build());
	}
	
	// Setters
	
	private void setCodigo(final UUID codigo) {
		this.codigo = UUIDHelper.getDefault(codigo, UUIDHelper.getDefault());
	}
	
	private void setNombre(final String nombre) {
		this.nombre = StringTool.applyTrim(nombre);
	}
	
	private void setPais(PaisDomain pais) {
		this.pais = ObjectHelper.getObjectHelper().getDefaultValue(pais, PaisDomain.build());
	}
	
	// Getters
	
	public final UUID getCodigo() {
		return codigo;
	}
	
	public final String getNombre() {
		return nombre;
	}

	public final PaisDomain getPais() {
		return pais;
	}
}
