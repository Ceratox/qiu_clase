package co.edu.uco.qiu.config.data.dao.entity;

import java.util.UUID;

import co.edu.uco.qiu.config.entity.localizacion.CiudadEntity;

public interface TipoIdUsuarioDAO extends CreateDAO<CiudadEntity>, RetrieveDAO<CiudadEntity>, UpdateDAO<CiudadEntity>, DeleteDAO<UUID> {

	
}
