package co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.qiu.config.crosscutting.exceptions.custom.CrosscuttingQIUException;
import co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.data.Message;
import co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.data.MessageCode;
import co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;

public final class MessageCatalogExternalService implements MessageCatalog {
	
	private final Map<String, Message> messages = new HashMap<>();

	@Override
	public final void initialize() {
		
		messages.clear();
		messages.put(MessageCode.M00007.getIdentifier(), new Message(MessageCode.M00007, "La transacción se ha completado de forma satisfactoria."));
		messages.put(MessageCode.M00010.getIdentifier(), new Message(MessageCode.M00010, "No se pudo completar la transacción por que no se enviarion los suficientes parámetros."));
	}

	@Override
	public final String getMessageContent(MessageCode code, String... params) {
		return StringTool.replaceParams(getMessage(code, params).getContent(), params);
	}

	@Override
	public final Message getMessage(MessageCode code, String... params) {
		
		if (ObjectHelper.getObjectHelper().isNull(code))
		{
			var userMessage = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
			var technicalMessage = MessageCatalogStrategy.getMessageContent(MessageCode.M00001);
			
			throw new CrosscuttingQIUException(technicalMessage, userMessage);
		}
		
		if (code.getIsBase())
		{
			var userMessage = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
			var technicalMessage = MessageCatalogStrategy.getMessageContent(MessageCode.M00005, code.getIdentifier());
			
			throw new CrosscuttingQIUException(technicalMessage, userMessage);
		}
		
		if (!messages.containsKey(code.getIdentifier()))
		{
			var userMessage = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
			var technicalMessage = MessageCatalogStrategy.getMessageContent(MessageCode.M00006, code.getIdentifier());
			
			throw new CrosscuttingQIUException(technicalMessage, userMessage);
		}
		
		return messages.get(code.getIdentifier());
	}

}
