package co.edu.uco.qiu.config.entity;

import java.util.UUID;

public class CoreEntity {
	
	private UUID codigo;
	
	protected CoreEntity () { super(); }
	
	public final CoreEntity setCodigo( UUID newCode )
	{
		this.codigo = newCode;
		return this;
	}
	
	public final UUID getCodigo() { return this.codigo; }

}
