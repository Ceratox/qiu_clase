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
import co.edu.uco.qiu.config.data.dao.entity.DepartamentoDAO;
import co.edu.uco.qiu.config.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.qiu.config.entity.localizacion.DepartamentoEntity;
import co.edu.uco.qiu.config.entity.localizacion.PaisEntity;

public class DepartamentoAzureSqlDAO extends SqlConnection implements DepartamentoDAO {
	
	private static final String TABLE = "departamento";
	private static final String[] UNIQUE_FIELDS = {"id", "nombre", "pais"};
	
	public DepartamentoAzureSqlDAO( Connection connection )
	{
		super(connection);
	}

	@Override
	public List<DepartamentoEntity> retrieve(DepartamentoEntity data) {
		
		List<DepartamentoEntity> deptos = new ArrayList<>();
		
		final StringBuilder sqlSentence = new StringBuilder();
		sqlSentence.append("SELECT * FROM " + TABLE + " WHERE ");
		
		for (int i=0; i<UNIQUE_FIELDS.length; i++)
		{
			sqlSentence.append(UNIQUE_FIELDS[i] + " = ?");
			if (i < UNIQUE_FIELDS.length - 1)
			{
				sqlSentence.append(" AND ");
			}
		}
		
		try (final PreparedStatement preparedSqlStatement = getConnection().prepareStatement(sqlSentence.toString()))
		{
			preparedSqlStatement.setObject(1, data.getCodigo());
			preparedSqlStatement.setString(2, data.getNombre());
			
			ResultSet resultSet = preparedSqlStatement.executeQuery();	
			
			while (resultSet.next())
			{
				deptos.add( new DepartamentoEntity( 
						
					UUID.fromString(Integer.toString(resultSet.getInt("id"))),
					resultSet.getString("nombre"),
					new PaisEntity()
					
				));
			}
			
			
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
		
		return deptos;
	}
}
