package co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog;

import co.edu.uco.qiu.config.crosscutting.exceptions.custom.CrosscuttingQIUException;
import co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.data.Message;
import co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.data.MessageCode;
import co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.impl.MessageCatalogBase;
import co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.impl.MessageCatalogExternalService;
import co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;

public final class MessageCatalogStrategy {
	
	private static final MessageCatalog base = new MessageCatalogBase();
	private static final MessageCatalog externalService = new MessageCatalogExternalService();
	
	static { initialize(); }
	
	private MessageCatalogStrategy()
	{
		super();
	}
	
	public static void initialize()
	{
		base.initialize();
		externalService.initialize();
	}
	
	private static final MessageCatalog getStrat( final boolean isBase )
	{
		return isBase ? base : externalService;
	}
	
	public static final Message getMessage( final MessageCode code, final String... params)
	{
		if (ObjectHelper.getObjectHelper().isNull(code))
		{
			var userMessage = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
			var technicalMessage = MessageCatalogStrategy.getMessageContent(MessageCode.M00001);
			
			throw new CrosscuttingQIUException(technicalMessage, userMessage);
		}
		
		return getStrat(code.getIsBase()).getMessage(code, params);
	}
	
	public static final String getMessageContent( final MessageCode code, final String... params )
	{	
		if (StringTool.messageParameters(getMessage(code).getContent()) > params.length)
		{
			var userMessage = getMessageContent(MessageCode.M00002);
			var technicalMessage = getMessageContent(MessageCode.M00009, code.getIdentifier());
			
			throw new CrosscuttingQIUException(technicalMessage, userMessage);
		}
		
		return StringTool.replaceParams(getMessage(code, params).getContent(), params) ;
	}
}
