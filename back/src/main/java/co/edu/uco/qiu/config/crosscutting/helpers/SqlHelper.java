package co.edu.uco.qiu.config.crosscutting.helpers;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.qiu.config.crosscutting.exceptions.custom.CrosscuttingQIUException;
import co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.data.MessageCode;

public final class SqlHelper {

	private SqlHelper() {
		super();
	}

	public static final boolean isNull(final Connection connection) {
		return ObjectHelper.getObjectHelper().isNull(connection);
	}

	public static final boolean isOpen(final Connection connection) {
		try {
			return !isNull(connection) && !connection.isClosed();
		} catch (final SQLException exception) {
			var mensajeUsuario = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getMessageContent(MessageCode.M00007);

			throw new CrosscuttingQIUException(mensajeTecnico, mensajeUsuario, exception);
		} catch (final Exception exception) {
			var mensajeUsuario = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getMessageContent(MessageCode.M00008);

			throw new CrosscuttingQIUException(mensajeTecnico, mensajeUsuario, exception);
		}
	}

	public static final void close(final Connection connection) {
		try {
			if (!isOpen(connection)) {
				var mensajeUsuario = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
				var mensajeTecnico = MessageCatalogStrategy.getMessageContent(MessageCode.M00009);

				throw new CrosscuttingQIUException(mensajeTecnico, mensajeUsuario);
			}

			connection.close();
		} catch (final CrosscuttingQIUException exception) {
			throw exception;
		} catch (final SQLException exception) {
			var mensajeUsuario = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getMessageContent(MessageCode.M00010);

			throw new CrosscuttingQIUException(mensajeTecnico, mensajeUsuario, exception);
		} catch (final Exception exception) {
			var mensajeUsuario = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getMessageContent(MessageCode.M00011);

			throw new CrosscuttingQIUException(mensajeTecnico, mensajeUsuario, exception);
		}
	}

	public static final void commit(final Connection connection) {
		try {
			if (!isOpen(connection)) {
				var mensajeUsuario = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
				var mensajeTecnico = MessageCatalogStrategy.getMessageContent(MessageCode.M00012);

				throw new CrosscuttingQIUException(mensajeTecnico, mensajeUsuario);
			}

			if (connection.getAutoCommit()) {
				var mensajeUsuario = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
				var mensajeTecnico = MessageCatalogStrategy.getMessageContent(MessageCode.M00013);

				throw new CrosscuttingQIUException(mensajeTecnico, mensajeUsuario);
			}

			connection.commit();
		} catch (final CrosscuttingQIUException exception) {
			throw exception;
		} catch (final SQLException exception) {
			var mensajeUsuario = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getMessageContent(MessageCode.M00014);

			throw new CrosscuttingQIUException(mensajeTecnico, mensajeUsuario, exception);
		} catch (final Exception exception) {
			var mensajeUsuario = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getMessageContent(MessageCode.M00015);

			throw new CrosscuttingQIUException(mensajeTecnico, mensajeUsuario, exception);
		}
	}

	public static final void rollback(final Connection connection) {
		try {
			if (!isOpen(connection)) {
				var mensajeUsuario = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
				var mensajeTecnico = MessageCatalogStrategy.getMessageContent(MessageCode.M00016);

				throw new CrosscuttingQIUException(mensajeTecnico, mensajeUsuario);
			}

			if (connection.getAutoCommit()) {
				var mensajeUsuario = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
				var mensajeTecnico = MessageCatalogStrategy.getMessageContent(MessageCode.M00017);

				throw new CrosscuttingQIUException(mensajeTecnico, mensajeUsuario);
			}

			connection.rollback();
		} catch (final CrosscuttingQIUException exception) {
			throw exception;
		} catch (final SQLException exception) {
			var mensajeUsuario = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getMessageContent(MessageCode.M00018);

			throw new CrosscuttingQIUException(mensajeTecnico, mensajeUsuario, exception);
		} catch (final Exception exception) {
			var mensajeUsuario = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getMessageContent(MessageCode.M00019);

			throw new CrosscuttingQIUException(mensajeTecnico, mensajeUsuario, exception);
		}
	}

	public static final void initTransaction(final Connection connection) {
		try {
			if (!isOpen(connection)) {
				var mensajeUsuario = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
				var mensajeTecnico = MessageCatalogStrategy.getMessageContent(MessageCode.M00020);

				throw new CrosscuttingQIUException(mensajeTecnico, mensajeUsuario);
			}

			connection.setAutoCommit(false);
		} catch (final CrosscuttingQIUException exception) {
			throw exception;
		} catch (final SQLException exception) {
			var mensajeUsuario = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getMessageContent(MessageCode.M00021);

			throw new CrosscuttingQIUException(mensajeTecnico, mensajeUsuario, exception);
		} catch (final Exception exception) {
			var mensajeUsuario = MessageCatalogStrategy.getMessageContent(MessageCode.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getMessageContent(MessageCode.M00022);

			throw new CrosscuttingQIUException(mensajeTecnico, mensajeUsuario, exception);
		}
	}
}
