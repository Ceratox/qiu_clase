package co.edu.uco.qiu.config.business.facade.impl.ciudad;

import co.edu.uco.qiu.config.business.assembler.dto.impl.localizacion.CiudadAssemblerDTO;
import co.edu.uco.qiu.config.business.facade.FacadeNoReturn;
import co.edu.uco.qiu.config.business.usecase.impl.ciudad.RegistrarCiudad;
import co.edu.uco.qiu.config.crosscutting.exceptions.QIUException;
import co.edu.uco.qiu.config.crosscutting.exceptions.custom.BusinessQIUException;
import co.edu.uco.qiu.config.data.dao.factory.DAOFactory;
import co.edu.uco.qiu.config.dto.localizacion.CiudadDTO;

public final class RegistrarCiudadFacade implements FacadeNoReturn<CiudadDTO>{
	
	private DAOFactory factory;
	
	public RegistrarCiudadFacade()
	{
		factory = DAOFactory.getFactory();
	}

	@Override
	public void execute(final CiudadDTO dto) {
		
		factory.startTransaction();
		
		try
		{
			var useCase = new RegistrarCiudad(factory);
			useCase.execute(CiudadAssemblerDTO.getInstance().toDomain(dto));
			
			factory.confirmTransaction();
		}
		catch (QIUException qe)
		{
			factory.cancelTransaction();
			
			var userMessage = "Se ha presentado un problema registrando la ciudad";
			var technicalMessage = "Se ha presentado un problema controlable registrando la ciudad";
			
			throw new BusinessQIUException(technicalMessage, userMessage, qe);
		}
		catch (Exception e)
		{
			factory.cancelTransaction();
			
			var userMessage = "Se ha presentado un problema inesperado registrando la ciudad";
			var technicalMessage = "Se ha presentado un problema INESPERADO registrando la ciudad";
			
			throw new BusinessQIUException(technicalMessage, userMessage, e);
		}
		finally 
		{
			factory.closeConnection();
		}
	}

}
