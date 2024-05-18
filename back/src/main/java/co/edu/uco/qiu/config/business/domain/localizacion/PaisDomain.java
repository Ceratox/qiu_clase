package co.edu.uco.qiu.config.business.domain.localizacion;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.crosscutting.helpers.UUIDHelper;

public final class PaisDomain {

	private UUID codigo;
	private String nombre;
	
	private PaisDomain(final UUID codigo, final String nombre)
	{
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public static final PaisDomain build(final UUID codigo, final String nombre)
	{
		return new PaisDomain(codigo, nombre);
	}
	
	public static final PaisDomain build(final UUID codigo)
	{
		return new PaisDomain(codigo, StringTool.EMPTY);
	}
	
	public static final PaisDomain build()
	{
		return new PaisDomain(UUIDHelper.getDefault(), StringTool.EMPTY);
	}
	
	// Setters
	
	private void setCodigo(final UUID codigo) {
		this.codigo = UUIDHelper.getDefault(codigo, UUIDHelper.getDefault());
	}
	
	private void setNombre(final String nombre) {
		this.nombre = StringTool.applyTrim(nombre);
	}
	
	// Getters
	
	public final UUID getCodigo() {
		return codigo;
	}
	
	public final String getNombre() {
		return nombre;
	}
	
	
}
