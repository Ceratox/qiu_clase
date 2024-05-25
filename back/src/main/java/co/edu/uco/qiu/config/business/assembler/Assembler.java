package co.edu.uco.qiu.config.business.assembler;

import java.util.List;

public interface Assembler<D, X> { // Domain to entity/dto

	D toDomain(X data);
	List<D> toDomain(List<X> data);
}
