package sda.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = "sda.spring")
@EnableJpaRepositories
@EnableTransactionManagement
@EntityScan(basePackageClasses = { Application.class, Jsr310JpaConverters.class })
public class Application {

	public static void main(final String... args) {
		new SpringApplication(Application.class).run(args);
	}

	// po uruchomieniu aplikacji zajrzyj na
	// http://localhost:8080/swagger-ui.html
	// dokumentacja spring security
	// https://spring.io/guides/gs/securing-web/

	// zabezpiecz rozne adresy
	// dodaj role do usera i popraw mapowanie na GrantedAuthority w UserService
	// dodaj @Secured('rola') na metodach i zobacz co sie dzieje
}
