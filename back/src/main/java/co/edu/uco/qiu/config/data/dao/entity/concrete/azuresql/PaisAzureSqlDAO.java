package co.edu.uco.qiu.config.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.qiu.config.data.dao.entity.PaisDAO;
import co.edu.uco.qiu.config.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.qiu.config.entity.localizacion.PaisEntity;

public class PaisAzureSqlDAO extends SqlConnection implements PaisDAO {
	
	public PaisAzureSqlDAO(Connection connection)
	{
		super(connection);
	}

	@Override
	public List<PaisEntity> retrieve(PaisEntity data) {
		
		return null;
	}
}
