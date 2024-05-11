package co.edu.uco.qiu.config.crosscutting.helpers;

public final class Phone {
	
	private int _prefix;
	private int _suffix;
	
	public Phone() {}
	
	public Phone( int prefix, int suffix )
	{
		setPrefix( prefix < 0 ? 0 : prefix );
		setSuffix( suffix < 0 ? 0 : suffix );
	}
	
	// Setters //
	
	public final Phone setPrefix( int newPrefix ) {
		this._prefix = newPrefix;
		return this;
	}
	
	public final Phone setSuffix( int newSuffix ) {
		this._suffix = newSuffix;
		return this;
	}
	
	// Getters //
	
	public int getPrefix() {return this._prefix;}
	
	public int getSuffix() {return this._suffix;}

}
