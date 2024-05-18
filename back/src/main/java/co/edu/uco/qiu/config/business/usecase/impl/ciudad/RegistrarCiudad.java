package co.edu.uco.qiu.config.business.usecase.impl.ciudad;

import java.util.UUID;

import co.edu.uco.qiu.config.business.assembler.entity.impl.localizacion.CiudadAssemblerEntity;
import co.edu.uco.qiu.config.business.assembler.entity.impl.localizacion.DepartamentoAssemblerEntity;
import co.edu.uco.qiu.config.business.domain.localizacion.CiudadDomain;
import co.edu.uco.qiu.config.business.usecase.UseCaseNoReturn;
import co.edu.uco.qiu.config.crosscutting.exceptions.custom.BusinessQIUException;
import co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.crosscutting.helpers.UUIDHelper;
import co.edu.uco.qiu.config.data.dao.factory.DAOFactory;
import co.edu.uco.qiu.config.entity.localizacion.CiudadEntity;
import co.edu.uco.qiu.config.entity.localizacion.DepartamentoEntity;

public final class RegistrarCiudad implements UseCaseNoReturn<CiudadDomain> {
	
	private DAOFactory factory;
	
	public RegistrarCiudad( final DAOFactory factory ) {
		
		if (ObjectHelper.getObjectHelper().isNull(factory))
		{
			String userMessage = "Se ha presentado un problema registrando la ciudad.";
			String technicalMessage = "El DAOFactory para crear la ciudad llegó nulo.";
			
			throw new BusinessQIUException(technicalMessage, userMessage, null);
		}
		
		this.factory = factory;
	}
	
	private final UUID generateCiudadUUID()
	{
		UUID codigo = UUIDHelper.generate();
		boolean codigoExists = true;
		
		while (codigoExists)
		{
			codigo = UUIDHelper.generate();
			CiudadEntity ciudadEnt = new CiudadEntity(codigo, StringTool.EMPTY, new DepartamentoEntity());
			var result = factory.getCiudadDAO().retrieve(ciudadEnt);
			codigoExists = !result.isEmpty();
		}
		
		return codigo;
	}
	
	private final void validateSimilaridadCiudadDepartamento(final String nombreCiudad, final String departamento, UUID idDepto)
	{
		CiudadEntity ciudadEnt = new CiudadEntity(UUIDHelper.getDefault(), nombreCiudad, new DepartamentoEntity());
				
		var result = factory.getCiudadDAO().retrieve(ciudadEnt);
		
		if (result.isEmpty())
		{
			
		}
		else
		{
			String userMessage = "Ya existe una ciudad con el mismo nombre ({0}) y departamento ({1}).";
			
			throw new BusinessQIUException(userMessage, userMessage, null);
		}
	}

	@Override
	public final void execute(CiudadDomain data) {
		
		// 1. Validar que los datos requeridos por el case de uso sean correctos según las especificaciones establecidas
		// 2. Validar que no exista otra ciudad con el mismo nombre y departamento
		// 3. Validar que no exista otra ciudad con el mismo código
		CiudadEntity ciudadEnt = new CiudadEntity(generateCiudadUUID(), data.getNombre(), DepartamentoAssemblerEntity.getInstance().toEntity(data.getDepartamento()));
		// Guardar la ciudad
		factory.getCiudadDAO().create(ciudadEnt);
	}
}
