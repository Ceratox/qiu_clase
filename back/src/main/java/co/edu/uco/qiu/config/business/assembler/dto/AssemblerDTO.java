package co.edu.uco.qiu.config.business.assembler.dto;

import java.util.List;

import co.edu.uco.qiu.config.business.assembler.Assembler;

public interface AssemblerDTO<D, X> extends Assembler<D, X> {

	X toDTO(D domain);
	List<X> toDTO(List<D> domainList);
}
