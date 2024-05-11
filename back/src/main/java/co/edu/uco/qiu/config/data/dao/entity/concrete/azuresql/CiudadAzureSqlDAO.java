package co.edu.uco.qiu.config.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.exceptions.custom.DataQIUException;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.data.dao.entity.CiudadDAO;
import co.edu.uco.qiu.config.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.qiu.config.entity.localizacion.CiudadEntity;

public final class CiudadAzureSqlDAO extends SqlConnection implements CiudadDAO {

	public CiudadAzureSqlDAO(final Connection connection) {
		
		super(connection);
	}

	@Override
	public final void create(final CiudadEntity data) {
		
		final StringBuilder sqlSentence = new StringBuilder();
		sqlSentence.append("INSERT INTO ciudad(codigo, nombre, departamento) ");
		sqlSentence.append("SELECT ?, ?, ?");
		
		try (final PreparedStatement preparedSqlStatement = getConnection().prepareStatement(sqlSentence.toString()))
		{
			preparedSqlStatement.setObject(1, data.getCodigo());
			preparedSqlStatement.setString(2, data.getNombre());
			preparedSqlStatement.setObject(3, data.getDepartamento().getCodigo());
			
			preparedSqlStatement.executeUpdate(); // La ciudad queda insertada
		}
		catch (SQLException exception)
		
		{
			var mensajeUsuario = StringTool.replaceParams("Se ha presentado un problema tratando de crear la ciudad \"{0}\".", data.getNombre());
			var mensajeTecnico = StringTool.replaceParams("Se ha presentado una excepción (SQLException) tratando de insertar la ciudad \"{0}\" en la tabla \"Ciudad\" de la base de datos AzureSQL.", data.getNombre());

			throw new DataQIUException(mensajeTecnico, mensajeUsuario, exception);
		}
		catch (Exception exception)
		{
			var mensajeUsuario = StringTool.replaceParams("Se ha presentado un problema tratando de crear la ciudad \"{0}\".", data.getNombre());
			var mensajeTecnico = StringTool.replaceParams("Se ha presentado una excepción **INESPERADA** (Exception) tratando de insertar la ciudad \"{0}\" en la tabla \"Ciudad\" de la base de datos AzureSQL.", data.getNombre());

			throw new DataQIUException(mensajeTecnico, mensajeUsuario, exception);
		}
	}

	@Override
	public List<CiudadEntity> retrieve(CiudadEntity data) {
		
		return null;
	}

	@Override
	public void update(CiudadEntity data) {
		
		
	}

	@Override
	public void delete(UUID codigo) {
				
		
	}

}
