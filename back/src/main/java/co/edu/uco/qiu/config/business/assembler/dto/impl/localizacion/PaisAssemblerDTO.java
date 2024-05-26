package co.edu.uco.qiu.config.business.assembler.dto.impl.localizacion;

import co.edu.uco.qiu.config.business.assembler.dto.AssemblerDTO;
import co.edu.uco.qiu.config.business.domain.localizacion.PaisDomain;
import co.edu.uco.qiu.config.dto.organizaciones.PaisDTO;

import static co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper.getObjectHelper;

import java.util.List;

public final class PaisAssemblerDTO implements AssemblerDTO<PaisDomain, PaisDTO>{
	
	private static final AssemblerDTO<PaisDomain, PaisDTO> INSTANCE = new PaisAssemblerDTO();
	
	private PaisAssemblerDTO() {super();}
	
	public static final AssemblerDTO<PaisDomain, PaisDTO> getInstance() {return INSTANCE;}

	@Override
	public PaisDomain toDomain(PaisDTO data) {
		
		PaisDTO paisDtoTmp = getObjectHelper().getDefaultValue(data, new PaisDTO());
		
		return PaisDomain.build(paisDtoTmp.getCodigo(), paisDtoTmp.getNombre());
	}

	@Override
	public PaisDTO toDTO(PaisDomain domain) {
		
		PaisDomain paisDomainTmp = getObjectHelper().getDefaultValue(domain, PaisDomain.build());
		
		return new PaisDTO(paisDomainTmp.getCodigo(), paisDomainTmp.getNombre());
	}

	@Override
	public List<PaisDomain> toDomain(List<PaisDTO> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDTO> toDTO(List<PaisDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
}
