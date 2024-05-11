package co.edu.uco.qiu.config.dto;

import java.util.UUID;

public class CoreDTO {
	
	private UUID codigo;
	
	protected CoreDTO () { super(); }
	
	public final CoreDTO setCodigo( UUID newCode )
	{
		this.codigo = newCode;
		return this;
	}
	
	public final UUID getCodigo() { return this.codigo; }

}
