package co.edu.uco.qiu.config.crosscutting.exceptions.custom;

import co.edu.uco.qiu.config.crosscutting.exceptions.QIUException;
import co.edu.uco.qiu.config.crosscutting.exceptions.enums.Place;

public class BusinessQIUException extends QIUException {

	private static final long serialVersionUID = 1619186187440729387L;

	public BusinessQIUException(String technicalMessage, String userMessage, Throwable rootException) {
		super(technicalMessage, userMessage, Place.BUSINESS, rootException);
	}

}
