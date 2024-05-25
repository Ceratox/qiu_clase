package co.edu.uco.qiu.config.data.dao.factory;

import co.edu.uco.qiu.config.data.dao.entity.CiudadDAO;
import co.edu.uco.qiu.config.data.dao.entity.DepartamentoDAO;
import co.edu.uco.qiu.config.data.dao.entity.PaisDAO;
import co.edu.uco.qiu.config.data.dao.factory.concrete.AzureSQLDAOFactory;

public interface DAOFactory {
	
	static DAOFactory getFactory()
	{
		return new AzureSQLDAOFactory();
	}

	void openConnection();
	void closeConnection();
	void startTransaction();
	void confirmTransaction();
	void cancelTransaction();
	
	PaisDAO getPaisDAO();
	DepartamentoDAO getDepartamentoDAO();
	CiudadDAO getCiudadDAO();
}
