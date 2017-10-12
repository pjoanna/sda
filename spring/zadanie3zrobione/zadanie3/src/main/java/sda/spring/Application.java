package sda.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sda.spring.beans.Address;
import sda.spring.beans.ComposedBean;
import sda.spring.beans.SimpleBean;
import sda.spring.beans.User;
import sda.spring.conf.ApplicationConfiguration;

//https://www.tutorialspoint.com/spring/spring_java_based_configuration.htm

public class Application {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		User user = applicationContext.getBean(User.class);

		System.out.println(applicationContext.getBean(SimpleBean.class).getValue());
//		Address address = applicationContext.getBean(Address.class);

		//pobaw sie, dodaj kilka wlasnych beanow, poskladaj je ze soba w zlozone struktury
		
		//zauwaz ze beany domyslnie sa tworzone w jednej instancji dla calego kontekstu
		System.out.println(user.getWorkAddress() == user.getAddress());
		
		//sprobuj dodac w³asne klasy konfiguracji tworzace twoje wlasne beany i dodac je do apliacji
		
		//sprobuj dodac propertisy tak aby SimpleBean otrzymal jakas wartosc w polu value 
		//(hint zobacz we wczeœniejszych zadaniach na xml i porownaj z anotacjami, wartosc mozna wstrzyknac za pomoca @Value
	}
}
