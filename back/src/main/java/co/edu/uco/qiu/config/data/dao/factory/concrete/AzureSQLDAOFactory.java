package co.edu.uco.qiu.config.data.dao.factory.concrete;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.qiu.config.crosscutting.helpers.SqlHelper;
import co.edu.uco.qiu.config.data.dao.entity.CiudadDAO;
import co.edu.uco.qiu.config.data.dao.entity.DepartamentoDAO;
import co.edu.uco.qiu.config.data.dao.entity.PaisDAO;
import co.edu.uco.qiu.config.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.qiu.config.data.dao.entity.concrete.azuresql.localizacion.CiudadAzureSqlDAO;
import co.edu.uco.qiu.config.data.dao.entity.concrete.azuresql.localizacion.DepartamentoAzureSqlDAO;
import co.edu.uco.qiu.config.data.dao.entity.concrete.azuresql.localizacion.PaisAzureSqlDAO;
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
			String connectionString = "jdbc:sqlserver://wednesday.database.windows.net:1433;database=friday;user=fridayDmlUser@wednesday.database.windows.net;password=fr1d4yus3r!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			setConnection(DriverManager.getConnection(connectionString));
		}
		catch (final SQLException exception)
		{
			System.out.println(exception);
		}
		catch (final Exception exception)
		{
			System.out.println(exception);
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
		SqlHelper.rollback(getConnection());
	}

	@Override
	public PaisDAO getPaisDAO() {
		
		return new PaisAzureSqlDAO(getConnection());
	}

	@Override
	public DepartamentoDAO getDepartamentoDAO() {
		
		return new DepartamentoAzureSqlDAO(getConnection());
	}

	@Override
	public CiudadDAO getCiudadDAO() {
		
		return new CiudadAzureSqlDAO(getConnection());
	}
}
