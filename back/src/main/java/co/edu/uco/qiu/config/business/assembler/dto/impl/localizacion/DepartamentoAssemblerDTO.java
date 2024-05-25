package co.edu.uco.qiu.config.business.assembler.dto.impl.localizacion;

import static co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper.getObjectHelper;

import java.util.List;

import co.edu.uco.qiu.config.business.assembler.dto.AssemblerDTO;
import co.edu.uco.qiu.config.business.domain.localizacion.DepartamentoDomain;
import co.edu.uco.qiu.config.business.domain.localizacion.PaisDomain;
import co.edu.uco.qiu.config.dto.localizacion.DepartamentoDTO;
import co.edu.uco.qiu.config.dto.localizacion.PaisDTO;

public final class DepartamentoAssemblerDTO implements AssemblerDTO<DepartamentoDomain, DepartamentoDTO>{
	
	private static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> INSTANCE = new DepartamentoAssemblerDTO();
	private static final AssemblerDTO<PaisDomain, PaisDTO> paisAssembler = PaisAssemblerDTO.getInstance();
	
	private DepartamentoAssemblerDTO() {super();}
	
	public static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> getInstance() {return INSTANCE;}
	
	@Override
	public DepartamentoDomain toDomain(DepartamentoDTO data) {
		
		DepartamentoDTO deptoDtoTmp = getObjectHelper().getDefaultValue(data, new DepartamentoDTO());
		
		return DepartamentoDomain.build(
				
				deptoDtoTmp.getCodigo(), 
				deptoDtoTmp.getNombre(), 
				paisAssembler.toDomain(deptoDtoTmp.getPais())
		);
	}

	@Override
	public DepartamentoDTO toDTO(DepartamentoDomain domain) {
		
		DepartamentoDomain deptoDomainTmp = getObjectHelper().getDefaultValue(domain, DepartamentoDomain.build());
		
		return new DepartamentoDTO(
				
				deptoDomainTmp.getCodigo(), 
				deptoDomainTmp.getNombre(), 
				paisAssembler.toDTO(deptoDomainTmp.getPais())
		);
	}

	@Override
	public List<DepartamentoDomain> toDomain(List<DepartamentoDTO> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoDTO> toDTO(List<DepartamentoDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}	
}
