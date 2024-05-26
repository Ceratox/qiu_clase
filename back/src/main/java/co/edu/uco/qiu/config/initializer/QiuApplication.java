package co.edu.uco.qiu.config.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.qiu.config.controller"})
public class QiuApplication {

	public static void main(String[] args) {
		SpringApplication.run(QiuApplication.class, args);
	}
}
