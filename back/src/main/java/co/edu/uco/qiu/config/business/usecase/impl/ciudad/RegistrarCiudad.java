package co.edu.uco.qiu.config.business.usecase.impl.ciudad;

import java.util.List;
import java.util.UUID;

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
	
	private final void validarSimilaridadCiudadDepartamento(final String nombreCiudad, final UUID deptoId)
	{
		CiudadEntity ciudadEnt = ((CiudadEntity)new CiudadEntity().setCodigo(UUIDHelper.getDefault())).setNombre(nombreCiudad).setDepartamento(
				
			(DepartamentoEntity)(new DepartamentoEntity().setCodigo(deptoId))
		);
				
		List<CiudadEntity> result = factory.getCiudadDAO().retrieve(ciudadEnt);
		
		if (!result.isEmpty())
		{
			String userMessage = StringTool.replaceParams("Ya existe una ciudad con el nombre ({0}) asociada al departamento cuyo UUID es {1}.", nombreCiudad, deptoId.toString());
			String technicalMessage = StringTool.replaceParams("Ya existe una ciudad con el nombre ({0}) asociada al departamento cuyo UUID es {1}.", nombreCiudad, deptoId.toString());
			
			throw new BusinessQIUException(technicalMessage, userMessage, null);
		}
	}
	
	private final void validateDepartamentoExistance(final UUID deptoId)
	{
		List<DepartamentoEntity> result = factory.getDepartamentoDAO().retrieve( (DepartamentoEntity)new DepartamentoEntity().setCodigo(deptoId) );
		
		if (result.isEmpty())
		{
			String userMessage = StringTool.replaceParams("No se pudo validar existencia de un departamento con UUID {0}", deptoId.toString());
			String technicalMessage = StringTool.replaceParams("No se pudo validar existencia de un departamento con UUID {0}", deptoId.toString());
			
			throw new BusinessQIUException(technicalMessage, userMessage, null);
		}
	}

	@Override
	public final void execute(CiudadDomain ciudad) {
		
		// 1. Validar que los datos requeridos por el case de uso sean correctos según las especificaciones establecidas
		validateDepartamentoExistance(ciudad.getDepartamento().getCodigo());
		
		// 2. Validar que no exista otra ciudad con el mismo nombre y departamento
		validarSimilaridadCiudadDepartamento(ciudad.getNombre(), ciudad.getDepartamento().getCodigo());
		
		// 3. Validar que no exista otra ciudad con el mismo código
		CiudadEntity ciudadEnt = (CiudadEntity)new CiudadEntity().setCodigo(generateCiudadUUID());
		ciudadEnt.setNombre(ciudad.getNombre()).setDepartamento(
				
			DepartamentoAssemblerEntity.getInstance().toEntity(ciudad.getDepartamento())
		);
		
		// Guardar la ciudad
		factory.getCiudadDAO().create(ciudadEnt);
	}
}
