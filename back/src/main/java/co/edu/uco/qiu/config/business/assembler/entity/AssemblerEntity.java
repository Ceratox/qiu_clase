package co.edu.uco.qiu.config.business.assembler.entity;

import co.edu.uco.qiu.config.business.assembler.Assembler;

public interface AssemblerEntity<D, X> extends Assembler<D, X> {

	X toEntity(D domain);
}
