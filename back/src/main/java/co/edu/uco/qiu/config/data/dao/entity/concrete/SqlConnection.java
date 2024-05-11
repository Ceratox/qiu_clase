package co.edu.uco.qiu.config.data.dao.entity.concrete;

import java.sql.Connection;

import co.edu.uco.qiu.config.crosscutting.exceptions.custom.CrosscuttingQIUException;
import co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.data.MessageCode;
import co.edu.uco.qiu.config.crosscutting.helpers.SqlHelper;

public class SqlConnection {

	private Connection connection;
	
	protected SqlConnection(final Connection connection)
	{
		setConnection(connection);
	}
	
	protected SqlConnection()
	{
		super();
	}
	
	protected final void setConnection(Connection connection) {
		
		if (!SqlHelper.isOpen(connection))
		{
			var mensajeUsuario = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
			var mensajeTecnico = "No es posible crear el DAO con una conexión cerrada.";

			throw new CrosscuttingQIUException(mensajeTecnico, mensajeUsuario);
		}
		
		this.connection = connection;
	}

	protected final Connection getConnection() {
		return connection;
	}
	
}
