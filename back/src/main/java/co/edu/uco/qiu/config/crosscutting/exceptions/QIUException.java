package co.edu.uco.qiu.config.crosscutting.exceptions;

import co.edu.uco.qiu.config.crosscutting.exceptions.enums.Place;
import co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;

public class QIUException extends RuntimeException {

	private static final long serialVersionUID = -1119971647684852037L;

	protected String _userMesaage;
	protected Place _exceptionPlace;
	protected String _techMessage;
	
	public QIUException(final String technicalMessage, final String userMessage, final Place exceptionPlace, final Throwable rootException)
	{
		super(technicalMessage, rootException);
		
		setUserMessage(userMessage);
		setExceptionPlace(exceptionPlace);
		setTechMessage(technicalMessage);
	}
	
	public QIUException(final String userMessage, final Place exceptionPlace)
	{
		super(userMessage, new Exception());
		
		setUserMessage(userMessage);
		setExceptionPlace(exceptionPlace);
	}
	
	public QIUException(final String technicalMessage, final String userMessage, final Place exceptionPlace)
	{
		super(technicalMessage, new Exception());
		
		setUserMessage(userMessage);
		setExceptionPlace(exceptionPlace);
		setTechMessage(technicalMessage);
	}

	public void setUserMessage(final String userMesaage) {
		this._userMesaage = StringTool.applyTrim(userMesaage);
	}
	
	public void setTechMessage(final String techMessage)
	{
		this._techMessage = techMessage;
	}

	public void setExceptionPlace(final Place lugar) {
		this._exceptionPlace = ObjectHelper.getObjectHelper().getDefaultValue(lugar, Place.CONFIG);
	}

	public final String getUserMesaage() {
		return this._userMesaage;
	}

	public final Place getExceptionPlace() {
		return this._exceptionPlace;
	}
	
	public String getTehMessage()
	{
		return this._techMessage;
	}
	
}
