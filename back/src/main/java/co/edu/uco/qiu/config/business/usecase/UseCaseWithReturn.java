package co.edu.uco.qiu.config.business.usecase;

public interface UseCaseWithReturn<T, R> {

	R execute(T data);
}
