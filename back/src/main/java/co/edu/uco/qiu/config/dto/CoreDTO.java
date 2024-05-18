package co.edu.uco.qiu.config.dto;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.UUIDHelper;

public class CoreDTO {
	
	private UUID codigo;
	
	protected CoreDTO () { super(); }
	
	public final CoreDTO setCodigo( UUID newCode )
	{
		this.codigo = UUIDHelper.getDefault(newCode, UUIDHelper.getDefault());
		return this;
	}
	
	public final UUID getCodigo() { return this.codigo; }

}
