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
import co.edu.uco.qiu.config.data.dao.entity.DepartamentoDAO;
import co.edu.uco.qiu.config.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.qiu.config.entity.localizacion.DepartamentoEntity;
import co.edu.uco.qiu.config.entity.localizacion.PaisEntity;

public class DepartamentoAzureSqlDAO extends SqlConnection implements DepartamentoDAO {
	
	public DepartamentoAzureSqlDAO( Connection connection )
	{
		super(connection);
	}

	@Override
	public List<DepartamentoEntity> retrieve(DepartamentoEntity data) {
		
		List<DepartamentoEntity> deptos = new ArrayList<>();
		
		final StringBuilder sqlSentence = new StringBuilder();
		
		if (UUIDHelper.isDefault(data.getCodigo()))
		{
			sqlSentence.append(
					
					"SELECT * FROM departamento d " +
					"JOIN pais p ON d.pais = p.id"
			);
		}
		else
		{
			sqlSentence.append(
					
				"SELECT d.id depto_cod, d.nombre depto_nom, p.id pais_cod, p.nombre pais_nom FROM departamento d " +
				"JOIN pais p ON d.pais = p.id " +
				"WHERE d.id = ? AND d.nombre = ? AND d.pais = ?"
					
			);
			
		}
		
		try (final PreparedStatement preparedSqlStatement = getConnection().prepareStatement(sqlSentence.toString()))
		{
			if (!UUIDHelper.isDefault(data.getCodigo()))
			{
				preparedSqlStatement.setObject(1, data.getCodigo());
				preparedSqlStatement.setString(2, data.getNombre());
				preparedSqlStatement.setObject(3, data.getPais().getCodigo());
			}
			
			ResultSet resultSet = preparedSqlStatement.executeQuery();	
			
			while (resultSet.next())
			{
				System.out.println(resultSet.getString("depto_nom"));
				deptos.add( new DepartamentoEntity( 
						
					UUID.fromString(resultSet.getObject("depto_cod").toString()),
					resultSet.getString("depto_nom"),
					(PaisEntity)new PaisEntity().setCodigo(UUID.fromString(resultSet.getObject("pais_cod").toString()))
					
				));
			}
			
			System.out.println(deptos.isEmpty());
			
			return deptos;
		}
		catch (SQLException exception)
		
		{
			var mensajeUsuario = StringTool.replaceParams("Se ha presentado un problema tratando de obtner el departamento \"{0}\".", data.getNombre());
			var mensajeTecnico = StringTool.replaceParams("Se ha presentado una excepción (SQLException) tratando de obtener el departamento \"{0}\" en la tabla \"Departamento\" de la base de datos AzureSQL.", data.getNombre());

			throw new DataQIUException(mensajeTecnico, mensajeUsuario, exception);
		}
		catch (Exception exception)
		{
			var mensajeUsuario = StringTool.replaceParams("Se ha presentado un problema tratando de obtner el departamento \\\"{0}\\\".", data.getNombre());
			var mensajeTecnico = StringTool.replaceParams("Se ha presentado una excepción **INESPERADA** (Exception) tratando de obtner el departamento \"{0}\" en la tabla \"Departamento\" de la base de datos AzureSQL.", data.getNombre());

			throw new DataQIUException(mensajeTecnico, mensajeUsuario, exception);
		}
	}
}
