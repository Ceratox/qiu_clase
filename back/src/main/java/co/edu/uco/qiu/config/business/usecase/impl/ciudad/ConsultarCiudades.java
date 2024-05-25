package co.edu.uco.qiu.config.business.usecase.impl.ciudad;

import java.util.List;

import co.edu.uco.qiu.config.business.assembler.entity.impl.localizacion.CiudadAssemblerEntity;
import co.edu.uco.qiu.config.business.domain.localizacion.CiudadDomain;
import co.edu.uco.qiu.config.business.usecase.UseCaseWithReturn;
import co.edu.uco.qiu.config.crosscutting.exceptions.custom.BusinessQIUException;
import co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper;
import co.edu.uco.qiu.config.data.dao.factory.DAOFactory;
import co.edu.uco.qiu.config.entity.localizacion.CiudadEntity;

public final class ConsultarCiudades implements UseCaseWithReturn<CiudadDomain, List<CiudadDomain>> {
	
	private DAOFactory factory;
	
	public ConsultarCiudades( final DAOFactory factory ) {
		
		if (ObjectHelper.getObjectHelper().isNull(factory))
		{
			String userMessage = "Se ha presentado un problema trantando de consultar las ciudades.";
			String technicalMessage = "El DAOFactory para consultar las ciudades llegó nulo.";
			
			throw new BusinessQIUException(technicalMessage, userMessage, null);
		}
		
		this.factory = factory;
	}

	@Override
	public final List<CiudadDomain> execute(final CiudadDomain ciudad) {
		
		CiudadEntity ciudadTemp = CiudadAssemblerEntity.getInstance().toEntity(ciudad);
		var results = factory.getCiudadDAO().retrieve(ciudadTemp);
		
		return CiudadAssemblerEntity.getInstance().toDomain(results);
	}

}
