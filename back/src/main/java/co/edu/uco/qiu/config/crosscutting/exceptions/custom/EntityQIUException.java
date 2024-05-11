package co.edu.uco.qiu.config.crosscutting.exceptions.custom;

import co.edu.uco.qiu.config.crosscutting.exceptions.QIUException;
import co.edu.uco.qiu.config.crosscutting.exceptions.enums.Place;

public class EntityQIUException extends QIUException  {

	private static final long serialVersionUID = -6316182992428832985L;

	public EntityQIUException(final String technicalMessage, final String userMessage, Throwable rootException) {
		super(technicalMessage, userMessage, Place.ENTITY, rootException);
	}
	
}
