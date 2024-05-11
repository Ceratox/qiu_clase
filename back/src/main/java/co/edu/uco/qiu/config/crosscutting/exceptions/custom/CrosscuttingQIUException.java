package co.edu.uco.qiu.config.crosscutting.exceptions.custom;

import co.edu.uco.qiu.config.crosscutting.exceptions.QIUException;
import co.edu.uco.qiu.config.crosscutting.exceptions.enums.Place;

public class CrosscuttingQIUException extends QIUException  {

	private static final long serialVersionUID = -6316182992428832985L;

	public CrosscuttingQIUException(final String technicalMessage, final String userMessage, Throwable rootException) {
		super(technicalMessage, userMessage, Place.CROSSCUTTING, rootException);
	}
	
	public CrosscuttingQIUException(final String technicalMessage, final String userMessage) {
		super(technicalMessage, userMessage, Place.CROSSCUTTING);
	}
	
}
