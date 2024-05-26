package co.edu.uco.qiu.config.data.dao.entity.concrete.azuresql.localizacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.exceptions.custom.DataQIUException;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.crosscutting.helpers.UUIDHelper;
import co.edu.uco.qiu.config.data.dao.entity.CiudadDAO;
import co.edu.uco.qiu.config.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.qiu.config.entity.localizacion.CiudadEntity;
import co.edu.uco.qiu.config.entity.localizacion.DepartamentoEntity;
import co.edu.uco.qiu.config.entity.localizacion.PaisEntity;

public final class CiudadAzureSqlDAO extends SqlConnection implements CiudadDAO {

	public CiudadAzureSqlDAO(final Connection connection) {
		
		super(connection);
	}

	@Override
	public final void create(final CiudadEntity data) {
		
		final StringBuilder sqlSentence = new StringBuilder();
		sqlSentence.append("INSERT INTO ciudad(id, nombre, departamento) ");
		sqlSentence.append("VALUES (?, ?, ?)");
		
		System.out.println(sqlSentence.toString());
		
		try (final PreparedStatement preparedSqlStatement = getConnection().prepareStatement(sqlSentence.toString()))
		{
			preparedSqlStatement.setObject(1, data.getCodigo());
			preparedSqlStatement.setString(2, data.getNombre());
			preparedSqlStatement.setObject(3, data.getDepartamento().getCodigo());
			
			System.out.println("OK");
			
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
	public List<CiudadEntity> retrieve(CiudadEntity ciudad) {
		
		final StringBuilder sqlSentence = new StringBuilder();
		
		if (UUIDHelper.isDefault(ciudad.getCodigo()))
		{
			sqlSentence.append(
					
				"SELECT c.id ciudad_cod, c.nombre ciudad_nom, d.id depto_cod, d.nombre depto_nom, p.id pais_cod, p.nombre pais_nom FROM ciudad c " +
				"JOIN departamento d ON c.departamento = d.id " +
				"JOIN pais p ON d.pais = p.id"
					
			);
			
		}
		else
		{
			sqlSentence.append(
					
				"SELECT c.id ciudad_cod, c.nombre ciudad_nom, d.id depto_cod FROM ciudad c " +
				"JOIN departamento d ON c.departamento = d.id " +
				"WHERE c.id = ? AND c.nombre = ?"
					
			);
		}
		
		System.out.println(sqlSentence.toString());
		
		try (final PreparedStatement preparedSqlStatement = getConnection().prepareStatement(sqlSentence.toString()))
		{
			if (!UUIDHelper.isDefault(ciudad.getCodigo()))
			{
				preparedSqlStatement.setObject(1, ciudad.getCodigo());
				preparedSqlStatement.setString(2, ciudad.getNombre());
			}
			
			ResultSet results = preparedSqlStatement.executeQuery();
			
			List<CiudadEntity> ciudades = new ArrayList<>();
			
			while (results.next())
			{
				ciudades.add(
						
					new CiudadEntity(UUID.fromString(results.getString("ciudad_cod")), results.getString("ciudad_nom"), 
							
						((DepartamentoEntity)new DepartamentoEntity().setCodigo(UUID.fromString(results.getString("depto_cod")))).setNombre(results.getString("depto_nom")).setPais(
								
								((PaisEntity)new PaisEntity().setCodigo(UUID.fromString(results.getString("pais_cod")))).setNombre(results.getString("pais_nom"))
								
						)
					)
				);
			}
			
			
			
			return ciudades;
		}
		catch (SQLException exception)
		
		{
			var mensajeUsuario = StringTool.replaceParams("Se ha presentado un problema tratando de recuperar los datos de la ciudad \"{0}\".", ciudad.getNombre());
			var mensajeTecnico = StringTool.replaceParams("Se ha presentado una excepción (SQLException) tratando de recuperar los datos de la ciudad \"{0}\" en la tabla \"Ciudad\" de la base de datos AzureSQL.", ciudad.getNombre());

			throw new DataQIUException(mensajeTecnico, mensajeUsuario, exception);
		}
		catch (Exception exception)
		{
			var mensajeUsuario = StringTool.replaceParams("Se ha presentado un problema tratando de recuperar los datos de la ciudad \\\"{0}\\\".", ciudad.getNombre());
			var mensajeTecnico = StringTool.replaceParams("Se ha presentado una excepción **INESPERADA** (Exception) tratando de recuperar los datos de la ciudad \"{0}\" en la tabla \"Ciudad\" de la base de datos AzureSQL.", ciudad.getNombre());

			throw new DataQIUException(mensajeTecnico, mensajeUsuario, exception);
		}
	}

	@Override
	public void update(CiudadEntity data) {
		
		final StringBuilder sqlSentence = new StringBuilder();
		sqlSentence.append("UPDATE ciudad SET nombre = ? , departamento = ? WHERE id = ?");
		
		System.out.println(sqlSentence.toString());
		
		try (final PreparedStatement preparedSqlStatement = getConnection().prepareStatement(sqlSentence.toString()))
		{
			preparedSqlStatement.setString(1, data.getNombre());
			preparedSqlStatement.setObject(2, data.getDepartamento().getCodigo());
			
			preparedSqlStatement.setObject(3, data.getCodigo());
			
			System.out.println("OK");
			
			preparedSqlStatement.executeUpdate(); // La ciudad queda actualizada
		}
		catch (SQLException exception)
		
		{
			var mensajeUsuario = StringTool.replaceParams("Se ha presentado un problema tratando de actualizar la ciudad \"{0}\".", data.getNombre());
			var mensajeTecnico = StringTool.replaceParams("Se ha presentado una excepción (SQLException) tratando de actualizar la ciudad \"{0}\" en la tabla \"Ciudad\" de la base de datos AzureSQL.", data.getNombre());

			throw new DataQIUException(mensajeTecnico, mensajeUsuario, exception);
		}
		catch (Exception exception)
		{
			var mensajeUsuario = StringTool.replaceParams("Se ha presentado un problema tratando de actualizar la ciudad \"{0}\".", data.getNombre());
			var mensajeTecnico = StringTool.replaceParams("Se ha presentado una excepción **INESPERADA** (Exception) tratando de actualizar la ciudad \"{0}\" en la tabla \"Ciudad\" de la base de datos AzureSQL.", data.getNombre());

			throw new DataQIUException(mensajeTecnico, mensajeUsuario, exception);
		}
	}

	@Override
	public void delete(final CiudadEntity ciudad) {
				
		final StringBuilder sqlSentence = new StringBuilder();
		sqlSentence.append("DELETE FROM ciudad WHERE id = ?");
		
		System.out.println(sqlSentence.toString());
		
		try (final PreparedStatement preparedSqlStatement = getConnection().prepareStatement(sqlSentence.toString()))
		{
			preparedSqlStatement.setObject(1, ciudad.getCodigo());
			
			System.out.println("OK");
			
			preparedSqlStatement.executeUpdate(); // La ciudad queda actualizada
		}
		catch (SQLException exception)
		
		{
			var mensajeUsuario = StringTool.replaceParams("Se ha presentado un problema tratando de borrar la ciudad \"{0}\".", ciudad.getNombre());
			var mensajeTecnico = StringTool.replaceParams("Se ha presentado una excepción (SQLException) tratando de borrar la ciudad \"{0}\" en la tabla \"Ciudad\" de la base de datos AzureSQL.", ciudad.getNombre());

			throw new DataQIUException(mensajeTecnico, mensajeUsuario, exception);
		}
		catch (Exception exception)
		{
			var mensajeUsuario = StringTool.replaceParams("Se ha presentado un problema tratando de borrar la ciudad \"{0}\".", ciudad.getNombre());
			var mensajeTecnico = StringTool.replaceParams("Se ha presentado una excepción **INESPERADA** (Exception) tratando de borrar la ciudad \"{0}\" en la tabla \"Ciudad\" de la base de datos AzureSQL.", ciudad.getNombre());

			throw new DataQIUException(mensajeTecnico, mensajeUsuario, exception);
		}
	}

}
