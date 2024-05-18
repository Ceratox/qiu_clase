package co.edu.uco.qiu.config.business.assembler.dto;

import co.edu.uco.qiu.config.business.assembler.Assembler;

public interface AssemblerDTO<D, X> extends Assembler<D, X> {

	X toDTO(D domain);
}
