package co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog;

import co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.data.Message;
import co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.data.MessageCode;

public interface MessageCatalog {

	void initialize();
	
	String getMessageContent(final MessageCode code, String... params);
	
	Message getMessage(final MessageCode code, String... params);
}
