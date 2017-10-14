package sda.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "sda.spring")
public class Application {

	public static void main(final String... args) {
		new SpringApplication(Application.class).run(args);
	}

}
