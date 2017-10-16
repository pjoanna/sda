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

	
	//po uruchomieniu aplikacji zajrzyj na http://localhost:8080/swagger-ui.html
	
	//dodaj walidacje do procesu rejestracji (@Valid, @NotBlank...)
	
	//dodaj wlasne endpointy REST, poprobuj ograniczyc ich dostepnosc dla roznych metod HTTP
	
	//dodaj globalna obsluge bledow za pomoca klasy z adnotacja @ControllerAdvice, obsluz w niej wszystkie mozliwe bledy korzystajac z  @ExceptionHandler(Exception.class) na metodzie
}
