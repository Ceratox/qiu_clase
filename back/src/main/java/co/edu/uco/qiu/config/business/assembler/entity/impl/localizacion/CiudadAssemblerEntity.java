package co.edu.uco.qiu.config.business.assembler.entity.impl.localizacion;

import co.edu.uco.qiu.config.business.assembler.entity.AssemblerEntity;
import co.edu.uco.qiu.config.business.domain.localizacion.CiudadDomain;
import co.edu.uco.qiu.config.business.domain.localizacion.DepartamentoDomain;
import co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper;
import co.edu.uco.qiu.config.entity.localizacion.CiudadEntity;
import co.edu.uco.qiu.config.entity.localizacion.DepartamentoEntity;

import static co.edu.uco.qiu.config.crosscutting.helpers.ObjectHelper.getObjectHelper;

import java.util.ArrayList;
import java.util.List;

public final class CiudadAssemblerEntity implements AssemblerEntity<CiudadDomain, CiudadEntity> {
	
	private static final AssemblerEntity<CiudadDomain, CiudadEntity> INSTANCE = new CiudadAssemblerEntity();
	private static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> deptoAssembler = DepartamentoAssemblerEntity.getInstance();
	
	private CiudadAssemblerEntity() {super();}
	
	public static final AssemblerEntity<CiudadDomain, CiudadEntity> getInstance() {return INSTANCE;}

	@Override
	public CiudadDomain toDomain(CiudadEntity data) {
		
		CiudadEntity ciudadEntityTmp = getObjectHelper().getDefaultValue(data, new CiudadEntity());
		
		return CiudadDomain.build(
				
			ciudadEntityTmp.getCodigo(),
			ciudadEntityTmp.getNombre(),
			deptoAssembler.toDomain(ciudadEntityTmp.getDepartamento())
		);
	}
	
	@Override
	public final List<CiudadDomain> toDomain(final List<CiudadEntity> ciudades) {
		
		var ciudadesEnities = ObjectHelper.getObjectHelper().getDefaultValue(ciudades, new ArrayList<CiudadEntity>());
		
		return ciudadesEnities.stream().map(this::toDomain).toList();
	}

	@Override
	public CiudadEntity toEntity(CiudadDomain domain) {
		
		CiudadDomain ciudadDomTmp = getObjectHelper().getDefaultValue(domain, CiudadDomain.build());
		
		return new CiudadEntity(
				
			ciudadDomTmp.getCodigo(),
			ciudadDomTmp.getNombre(),
			deptoAssembler.toEntity(ciudadDomTmp.getDepartamento())
		);
	}

	@Override
	public List<CiudadEntity> toEntity(List<CiudadDomain> ciudades) {
		
		var ciudadesDomain = ObjectHelper.getObjectHelper().getDefaultValue(ciudades, new ArrayList<CiudadDomain>());
		
		return ciudadesDomain.stream().map(this::toEntity).toList();
	}
}
