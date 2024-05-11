package co.edu.uco.qiu.config.data.dao.entity;

import java.util.List;

interface RetrieveDAO <E> {

	List<E> retrieve(E data);
	
}
