package co.edu.uco.qiu.config.business.assembler.dto.impl.localizacion;

import static co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper.getObjectHelper;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.qiu.config.business.assembler.dto.AssemblerDTO;
import co.edu.uco.qiu.config.business.domain.localizacion.CiudadDomain;
import co.edu.uco.qiu.config.business.domain.localizacion.DepartamentoDomain;
import co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper;
import co.edu.uco.qiu.config.dto.localizacion.CiudadDTO;
import co.edu.uco.qiu.config.dto.localizacion.DepartamentoDTO;

public final class CiudadAssemblerDTO implements AssemblerDTO<CiudadDomain, CiudadDTO>{
	
	private static final AssemblerDTO<CiudadDomain, CiudadDTO> INSTANCE = new CiudadAssemblerDTO();
	private static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> departamentoAssembler = DepartamentoAssemblerDTO.getInstance();
	
	private CiudadAssemblerDTO() {super();}
	
	public static final AssemblerDTO<CiudadDomain, CiudadDTO> getInstance() {return INSTANCE;}

	@Override
	public CiudadDomain toDomain(CiudadDTO data) {
		
		CiudadDTO ciudadDtoTmp = getObjectHelper().getDefaultValue(data, new CiudadDTO());
		
		return CiudadDomain.build(
				
				ciudadDtoTmp.getCodigo(), 
				ciudadDtoTmp.getNombre(), 
				departamentoAssembler.toDomain(ciudadDtoTmp.getDepartamento())
		);
	}
	
	@Override
	public List<CiudadDomain> toDomain(List<CiudadDTO> ciudades) {
		
		var ciudadesDTO = ObjectHelper.getObjectHelper().getDefaultValue(ciudades, new ArrayList<CiudadDTO>());
		
		return ciudadesDTO.stream().map(this::toDomain).toList();
	}	

	@Override
	public CiudadDTO toDTO(CiudadDomain domain) {
		
		CiudadDomain ciudadDomainTmp = getObjectHelper().getDefaultValue(domain, CiudadDomain.build());
		
		return new CiudadDTO(
				
				ciudadDomainTmp.getCodigo(), 
				ciudadDomainTmp.getNombre(), 
				departamentoAssembler.toDTO(ciudadDomainTmp.getDepartamento())
		);
	}

	@Override
	public List<CiudadDTO> toDTO(final List<CiudadDomain> ciudades) {
		
		var ciudadesDomain = ObjectHelper.getObjectHelper().getDefaultValue(ciudades, new ArrayList<CiudadDomain>());
		
		return ciudadesDomain.stream().map(this::toDTO).toList();
	}
}
