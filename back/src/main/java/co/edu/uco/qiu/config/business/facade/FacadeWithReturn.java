package co.edu.uco.qiu.config.business.facade;

public interface FacadeWithReturn <T, K>{

	K execute(T dto);
}
