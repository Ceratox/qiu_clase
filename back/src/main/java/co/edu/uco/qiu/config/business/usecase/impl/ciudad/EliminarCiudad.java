package co.edu.uco.qiu.config.business.usecase.impl.ciudad;

import co.edu.uco.qiu.config.business.assembler.entity.impl.localizacion.DepartamentoAssemblerEntity;
import co.edu.uco.qiu.config.business.domain.localizacion.CiudadDomain;
import co.edu.uco.qiu.config.business.usecase.UseCaseNoReturn;
import co.edu.uco.qiu.config.crosscutting.exceptions.custom.BusinessQIUException;
import co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper;
import co.edu.uco.qiu.config.data.dao.factory.DAOFactory;
import co.edu.uco.qiu.config.entity.localizacion.CiudadEntity;

public class EliminarCiudad implements UseCaseNoReturn<CiudadDomain> {
	
	private DAOFactory factory;

	public EliminarCiudad( final DAOFactory factory ) {
		
		if (ObjectHelper.getObjectHelper().isNull(factory))
		{
			String userMessage = "Se ha presentado un problema registrando la ciudad.";
			String technicalMessage = "El DAOFactory para crear la ciudad llegó nulo.";
			
			throw new BusinessQIUException(technicalMessage, userMessage, null);
		}
		
		this.factory = factory;
	}

	@Override
	public final void execute(CiudadDomain ciudad) {
		
		System.out.println(ciudad.getDepartamento().getCodigo());
		
		CiudadEntity ciudadEnt = (CiudadEntity)new CiudadEntity().setCodigo(ciudad.getCodigo());
		ciudadEnt.setNombre(ciudad.getNombre()).setDepartamento(
				
			DepartamentoAssemblerEntity.getInstance().toEntity(ciudad.getDepartamento())
		);
		// Guardar la ciudad
		factory.getCiudadDAO().delete(ciudadEnt);
	}
}
