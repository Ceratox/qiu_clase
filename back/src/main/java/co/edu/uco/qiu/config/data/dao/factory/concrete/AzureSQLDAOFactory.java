package co.edu.uco.qiu.config.data.dao.factory.concrete;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.qiu.config.crosscutting.helpers.SqlHelper;
import co.edu.uco.qiu.config.data.dao.entity.CiudadDAO;
import co.edu.uco.qiu.config.data.dao.entity.DepartamentoDAO;
import co.edu.uco.qiu.config.data.dao.entity.PaisDAO;
import co.edu.uco.qiu.config.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.qiu.config.data.dao.entity.concrete.azuresql.PaisAzureSqlDAO;
import co.edu.uco.qiu.config.data.dao.factory.DAOFactory;

public final class AzureSQLDAOFactory extends SqlConnection implements DAOFactory {
	
	public AzureSQLDAOFactory() {
		
		super();
		
		openConnection();
	}

	@Override
	public void openConnection() {
		
		try
		{
			String connectionString = "jdbc ....";
			setConnection(DriverManager.getConnection(connectionString));
		}
		catch (final SQLException exception)
		{
			
		}
		catch (final Exception exception)
		{
			
		}
	}

	@Override
	public void closeConnection() {
		
		SqlHelper.close(getConnection());
	}

	@Override
	public void startTransaction() {
		
		SqlHelper.initTransaction(getConnection());
		
	}

	@Override
	public void confirmTransaction() {
		
		SqlHelper.commit(getConnection());
		
	}

	@Override
	public void cancelTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaisDAO getPaisDAO() {
		
		return new PaisAzureSqlDAO(getConnection());
	}

	@Override
	public DepartamentoDAO getDepartamentoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CiudadDAO getCiudadDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
