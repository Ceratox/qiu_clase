package co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.qiu.config.crosscutting.exceptions.custom.CrosscuttingQIUException;
import co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.data.Message;
import co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.data.MessageCode;
import co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;

public final class MessageCatalogBase implements MessageCatalog {

	private final Map<String, Message> messages = new HashMap<>();
	
	@Override
	public final void initialize() {
	
		messages.clear();
		messages.put(MessageCode.M00001.getIdentifier(), new Message(MessageCode.M00001, "El código del mensaje que se quiere obtener del catalogo de messages llegó nulo."));
		messages.put(MessageCode.M00002.getIdentifier(), new Message(MessageCode.M00002, "Se ha presentado un problema tratando de llevar a cabo la operación deseada."));
		messages.put(MessageCode.M00003.getIdentifier(), new Message(MessageCode.M00003, "El identificador del mensaje \"{0}\" que se intentó obtener no está en el catálogo de messages base."));
		messages.put(MessageCode.M00004.getIdentifier(), new Message(MessageCode.M00004, "El mensaje con identificador \"{0}\" que se intentó obtener no está configurado para residir en el catálogo de messages base."));
		messages.put(MessageCode.M00005.getIdentifier(), new Message(MessageCode.M00005, "El mensaje con identificador \"{0}\" que se intentó obtener no está configurado para residir en el catálogo de messages externo."));
		messages.put(MessageCode.M00006.getIdentifier(), new Message(MessageCode.M00006, "El identificador del mensaje \"{0}\" que se intentó obtener no está en el catálogo de messages externo."));
 
		messages.put(MessageCode.M00007.getIdentifier(), new Message(MessageCode.M00007,
				"Se ha presentado un problema tratando de validar si la conexión SQL con la fuente de información deseada estaba cerrada..."));
		messages.put(MessageCode.M00008.getIdentifier(), new Message(MessageCode.M00008,
				"Se ha presentado un problema INESPERADO tratando de validar si la conexión SQL con la fuente de información deseada estaba cerrada..."));
		messages.put(MessageCode.M00009.getIdentifier(), new Message(MessageCode.M00009,
				"Se ha intentado realizar el cierre de una conexión SQL que ya estaba cerrada..."));
		messages.put(MessageCode.M00010.getIdentifier(), new Message(MessageCode.M00010,
				"Se ha presentado un problema tratando de cerrar la conexión SQL con la fuente de información deseada..."));
		messages.put(MessageCode.M00011.getIdentifier(), new Message(MessageCode.M00011,
				"Se ha presentado un problema INESPERADO tratando de cerrar la conexión SQL con la fuente de información deseada..."));
		messages.put(MessageCode.M00012.getIdentifier(), new Message(MessageCode.M00012,
				"Se ha intentado confirmar una transacción con una conexión SQL cerrada..."));
		messages.put(MessageCode.M00013.getIdentifier(), new Message(MessageCode.M00013,
				"Se ha intentado confirmar una transacción cuando el autocommit de la conexión con la base de datos estaba activado..."));
		messages.put(MessageCode.M00014.getIdentifier(), new Message(MessageCode.M00014,
				"Se ha presentado un problema tratando de confirmar una transacción SQL con la fuente de información deseada..."));
		messages.put(MessageCode.M00015.getIdentifier(), new Message(MessageCode.M00015,
				"Se ha presentado un problema INESPERADO tratando de confirmar una transacción SQL con la fuente de información deseada..."));
		messages.put(MessageCode.M00016.getIdentifier(), new Message(MessageCode.M00016,
				"Se ha intentado cancelar una transacción con una conexión SQL cerrada..."));
		messages.put(MessageCode.M00017.getIdentifier(), new Message(MessageCode.M00017,
				"Se ha intentado cancelar una transacción cuando el autocommit de la conexión con la base de datos estaba activado..."));
		messages.put(MessageCode.M00018.getIdentifier(), new Message(MessageCode.M00018,
				"Se ha presentado un problema tratando de cancelar una transacción SQL con la fuente de información deseada..."));
		messages.put(MessageCode.M00019.getIdentifier(), new Message(MessageCode.M00019,
				"Se ha presentado un problema INESPERADO tratando de cancelar una transacción SQL con la fuente de información deseada..."));
 
		messages.put(MessageCode.M00020.getIdentifier(), new Message(MessageCode.M00020,
				"Se ha intentado iniciar una transacción con una conexión SQL cerrada..."));
		messages.put(MessageCode.M00021.getIdentifier(), new Message(MessageCode.M00022,
				"Se ha presentado un problema tratando de iniciar una transacción SQL con la fuente de información deseada..."));
		messages.put(MessageCode.M00022.getIdentifier(), new Message(MessageCode.M00022,
				"Se ha presentado un problema INESPERADO tratando de iniciar una transacción SQL con la fuente de información deseada..."));
	}

	@Override
	public final String getMessageContent(MessageCode code, String... params) {
		
		return StringTool.replaceParams(getMessage(code, params).getContent(), params);
	}

	@Override
	public final Message getMessage(final MessageCode code, final String... params) {
		
		if (ObjectHelper.getObjectHelper().isNull(code))
		{
			var userMessage = getMessageContent(MessageCode.M00002);
			var technicalMessage = getMessageContent(MessageCode.M00001);
			
			throw new CrosscuttingQIUException(technicalMessage, userMessage);
		}
		
		if (!code.getIsBase())
		{
			var userMessage = getMessageContent(MessageCode.M00002);
			var technicalMessage = getMessageContent(MessageCode.M00004, code.getIdentifier());
			
			throw new CrosscuttingQIUException(technicalMessage, userMessage);
		}
		
		if (!messages.containsKey(code.getIdentifier()))
		{
			var userMessage = getMessageContent(MessageCode.M00002);
			var technicalMessage = getMessageContent(MessageCode.M00003, code.getIdentifier());
			
			throw new CrosscuttingQIUException(technicalMessage, userMessage);
		}
		
		return messages.get(code.getIdentifier());
	}
	
}
