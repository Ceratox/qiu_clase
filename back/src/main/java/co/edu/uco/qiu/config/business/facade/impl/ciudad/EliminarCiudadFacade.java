package co.edu.uco.qiu.config.business.facade.impl.ciudad;

import co.edu.uco.qiu.config.business.assembler.dto.impl.localizacion.CiudadAssemblerDTO;
import co.edu.uco.qiu.config.business.facade.FacadeNoReturn;
import co.edu.uco.qiu.config.business.usecase.impl.ciudad.EliminarCiudad;
import co.edu.uco.qiu.config.crosscutting.exceptions.QIUException;
import co.edu.uco.qiu.config.crosscutting.exceptions.custom.BusinessQIUException;
import co.edu.uco.qiu.config.data.dao.factory.DAOFactory;
import co.edu.uco.qiu.config.dto.organizaciones.CiudadDTO;

public class EliminarCiudadFacade implements FacadeNoReturn<CiudadDTO> {

private DAOFactory factory;
	
	public EliminarCiudadFacade()
	{
		factory = DAOFactory.getFactory();
	}

	@Override
	public void execute(final CiudadDTO dto) {
		
		factory.startTransaction();
		
		try
		{
			var useCase = new EliminarCiudad(factory);
			useCase.execute(CiudadAssemblerDTO.getInstance().toDomain(dto));
			
			factory.confirmTransaction();
		}
		catch (QIUException qe)
		{
			factory.cancelTransaction();
			
			var userMessage = "Se ha presentado un problema eliminando la ciudad";
			var technicalMessage = "Se ha presentado un problema controlable eliminando la ciudad";
			
			throw new BusinessQIUException(technicalMessage, userMessage, qe);
		}
		catch (Exception e)
		{
			factory.cancelTransaction();
			
			var userMessage = "Se ha presentado un problema inesperado eliminando la ciudad";
			var technicalMessage = "Se ha presentado un problema INESPERADO eliminando la ciudad";
			
			throw new BusinessQIUException(technicalMessage, userMessage, e);
		}
		finally 
		{
			factory.closeConnection();
		}
	}
}
