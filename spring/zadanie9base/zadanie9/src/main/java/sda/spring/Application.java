package sda.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = "sda.spring")
@EnableJpaRepositories
@EnableTransactionManagement
public class Application {

	public static void main(final String... args) {
		new SpringApplication(Application.class).run(args);
	}

	
	//po uruchomieniu aplikacji zajrzyj na http://localhost:8080/swagger-ui.html
	//dokumentacja spring data 
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
	//https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html
	
	//dodaj kolejne encje i kontrolery obs³ugujace CRUD dla nich poprzez REST
	
	//powiaz ze soba encje i dodaj kontroller ktory bedzie wyszukiwal rozne dane po zaleznych polach
	//encja Kurs, ktora ma Userow, encja Adres ktora jest i w Kursie i w userze, encja Praca ktora ma userow i adres
	//Praca zapewnia Kurs, Praca daje Pensje. Poszukajmy userow ktorzy odbyli dany kurs i pracuja w danym miejscu, maja placone wiecej niz X
	//Poszukajmy userow ktorzy maja okreslony adres i uczestniczyli w danym kursie, poszukajmy pracy ktora zapewnia conajmniej 2 kursy i pracuje w niej
}
