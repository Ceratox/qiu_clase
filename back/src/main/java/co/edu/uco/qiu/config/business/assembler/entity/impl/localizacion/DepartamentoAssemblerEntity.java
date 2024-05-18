package co.edu.uco.qiu.config.business.assembler.entity.impl.localizacion;

import co.edu.uco.qiu.config.business.assembler.entity.AssemblerEntity;
import co.edu.uco.qiu.config.business.domain.localizacion.DepartamentoDomain;
import co.edu.uco.qiu.config.business.domain.localizacion.PaisDomain;
import co.edu.uco.qiu.config.entity.localizacion.PaisEntity;
import co.edu.uco.qiu.config.entity.localizacion.DepartamentoEntity;

import static co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper.getObjectHelper;

public final class DepartamentoAssemblerEntity implements AssemblerEntity<DepartamentoDomain, DepartamentoEntity> {
	
	private static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> INSTANCE = new DepartamentoAssemblerEntity();
	private static final AssemblerEntity<PaisDomain, PaisEntity> paisAssembler = PaisAssemblerEntity.getInstance();
	
	private DepartamentoAssemblerEntity() {super();}
	
	public static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> getInstance() {return INSTANCE;}

	@Override
	public DepartamentoDomain toDomain(DepartamentoEntity data) {
		
		DepartamentoEntity deptoEntityTmp = getObjectHelper().getDefaultValue(data, new DepartamentoEntity());
		
		return DepartamentoDomain.build(
				
				deptoEntityTmp.getCodigo(),
				deptoEntityTmp.getNombre(),
				paisAssembler.toDomain(deptoEntityTmp.getPais())
		);
	}

	@Override
	public DepartamentoEntity toEntity(DepartamentoDomain domain) {
		
		DepartamentoDomain deptoDomTmp = getObjectHelper().getDefaultValue(domain, DepartamentoDomain.build());
		
		return new DepartamentoEntity(
				
				deptoDomTmp.getCodigo(),
				deptoDomTmp.getNombre(),
				paisAssembler.toEntity(deptoDomTmp.getPais())
		);
	}
}
