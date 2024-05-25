package co.edu.uco.qiu.config.business.assembler.entity.impl.localizacion;

import co.edu.uco.qiu.config.business.assembler.entity.AssemblerEntity;
import co.edu.uco.qiu.config.business.domain.localizacion.PaisDomain;
import co.edu.uco.qiu.config.entity.localizacion.PaisEntity;
import static co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper.getObjectHelper;

import java.util.List;

public final class PaisAssemblerEntity implements AssemblerEntity<PaisDomain, PaisEntity> {
	
	private static final AssemblerEntity<PaisDomain, PaisEntity> INSTANCE = new PaisAssemblerEntity();
	
	private PaisAssemblerEntity() {super();}
	
	public static final AssemblerEntity<PaisDomain, PaisEntity> getInstance() {return INSTANCE;}

	@Override
	public PaisDomain toDomain(PaisEntity data) {
		
		PaisEntity paisEntityTmp = getObjectHelper().getDefaultValue(data, new PaisEntity());
		
		return PaisDomain.build(
				
				paisEntityTmp.getCodigo(),
				paisEntityTmp.getNombre()
		);
	}

	@Override
	public PaisEntity toEntity(PaisDomain domain) {
		
		PaisDomain paisDomTmp = getObjectHelper().getDefaultValue(domain, PaisDomain.build());
		
		return new PaisEntity(
				
				paisDomTmp.getCodigo(),
				paisDomTmp.getNombre()
		);
	}

	@Override
	public List<PaisDomain> toDomain(List<PaisEntity> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisEntity> toEntity(List<PaisDomain> domain) {
		// TODO Auto-generated method stub
		return null;
	}
}
