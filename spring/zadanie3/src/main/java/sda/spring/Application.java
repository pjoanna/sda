package sda.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sda.spring.beans.*;
import sda.spring.conf.ApplicationConfiguration;

//https://www.tutorialspoint.com/spring/spring_java_based_configuration.htm

public class Application {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		SimpleBean simple = applicationContext.getBean(SimpleBean.class);

		System.out.println(simple.getValue());
		
		ComposedBean composed = (ComposedBean) applicationContext.getBean("composed");

		//pobaw sie, dodaj kilka wlasnych beanow, poskladaj je ze soba w zlozone struktury
		
		//zauwaz ze beany domyslnie sa tworzone w jednej instancji dla calego kontekstu
		System.out.println(composed.getSimple() == simple);

		Address address = (Address) applicationContext.getBean("address");
		User user = (User) applicationContext.getBean("user");

		System.out.println(address.getCity());

		System.out.println(user.toString());

        ConstructorInjected injected = (ConstructorInjected) applicationContext.getBean("injected");
        System.out.println(injected.getSimple().getValue());
        //sprobuj dodac w�asne klasy konfiguracji tworzace twoje wlasne beany i dodac je do apliacji
		
		//sprobuj dodac propertisy tak aby SimpleBean otrzymal jakas wartosc w polu value 
		//(hint zobacz we wcze�niejszych zadaniach na xml i porownaj z anotacjami, wartosc mozna wstrzyknac za pomoca @Value
	}
}
