package co.edu.uco.qiu.config.crosscutting.helpers;

import co.edu.uco.qiu.config.crosscutting.exceptions.custom.DtoQIUException;

public final class ExceptionHandler {
	
	private ExceptionHandler() {}
	
	public static <O> void checkDtoNullParameter( O parameter )
	{
		if (parameter == null)
		{
			throw new DtoQIUException("Provided parameter was null.", "Null parameter!", null);
		}
	}
}
