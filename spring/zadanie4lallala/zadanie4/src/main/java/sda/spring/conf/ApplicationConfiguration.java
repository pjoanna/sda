package sda.spring.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("sda.spring")
@PropertySource("application.properties")
public class ApplicationConfiguration {
	

}
