package co.edu.uco.qiu.config.business.assembler.dto.impl.localizacion;

import co.edu.uco.qiu.config.business.assembler.dto.AssemblerDTO;
import co.edu.uco.qiu.config.business.domain.localizacion.PaisDomain;
import static co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper.getObjectHelper;
import co.edu.uco.qiu.config.dto.localizacion.PaisEntity;

public final class PaisAssemblerDTO implements AssemblerDTO<PaisDomain, PaisEntity>{
	
	private static final AssemblerDTO<PaisDomain, PaisEntity> INSTANCE = new PaisAssemblerDTO();
	
	private PaisAssemblerDTO() {super();}
	
	public static final AssemblerDTO<PaisDomain, PaisEntity> getInstance() {return INSTANCE;}

	@Override
	public PaisDomain toDomain(PaisEntity data) {
		
		PaisEntity paisDtoTmp = getObjectHelper().getDefaultValue(data, new PaisEntity());
		
		return PaisDomain.build(paisDtoTmp.getCodigo(), paisDtoTmp.getNombre());
	}

	@Override
	public PaisEntity toDTO(PaisDomain domain) {
		
		PaisDomain paisDomainTmp = getObjectHelper().getDefaultValue(domain, PaisDomain.build());
		
		return new PaisEntity(paisDomainTmp.getCodigo(), paisDomainTmp.getNombre());
	}
}
