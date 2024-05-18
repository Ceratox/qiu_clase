package co.edu.uco.qiu.config.business.assembler;

public interface Assembler<D, X> { // Domain to entity/dto

	D toDomain(X data);
}
