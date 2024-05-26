package co.edu.uco.qiu.config.business.facade.impl.ciudad;

import java.util.List;

import co.edu.uco.qiu.config.business.assembler.dto.impl.localizacion.CiudadAssemblerDTO;
import co.edu.uco.qiu.config.business.facade.FacadeWithReturn;
import co.edu.uco.qiu.config.business.usecase.impl.ciudad.ConsultarCiudades;
import co.edu.uco.qiu.config.crosscutting.exceptions.QIUException;
import co.edu.uco.qiu.config.crosscutting.exceptions.custom.BusinessQIUException;
import co.edu.uco.qiu.config.data.dao.factory.DAOFactory;
import co.edu.uco.qiu.config.dto.organizaciones.CiudadDTO;

public final class ConsultarCiudadesFacade implements FacadeWithReturn<CiudadDTO, List<CiudadDTO>> {
	
	private DAOFactory factory;
	
	public ConsultarCiudadesFacade()
	{
		factory = DAOFactory.getFactory();
	}

	@Override
	public List<CiudadDTO> execute(final CiudadDTO dto) {
		
		try
		{
			var useCase = new ConsultarCiudades(factory);
			var resultsDomain = useCase.execute(CiudadAssemblerDTO.getInstance().toDomain(dto));
			
			return CiudadAssemblerDTO.getInstance().toDTO(resultsDomain);
		}
		catch (QIUException qe)
		{
			var userMessage = "Se ha presentado un problema consultando la información de las ciudades";
			var technicalMessage = "Se ha presentado un problema controlable consultando la información de las ciudades";
			
			throw new BusinessQIUException(technicalMessage, userMessage, qe);
		}
		catch (Exception e)
		{
			var userMessage = "Se ha presentado un problema consultando la información de las ciudades";
			var technicalMessage = "Se ha presentado un problema INESPERADO consultando la información de las ciudades";
			
			throw new BusinessQIUException(technicalMessage, userMessage, e);
		}
		finally 
		{
			factory.closeConnection();
		}
	}

}
