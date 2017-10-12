package sda.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sda.spring.beans.ComposedBean;
import sda.spring.beans.SimpleBean;
import sda.spring.conf.ApplicationConfiguration;


public class Application {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		SimpleBean simple = applicationContext.getBean(SimpleBean.class);

		System.out.println(simple.getValue());
		
		ComposedBean composed = (ComposedBean) applicationContext.getBean(ComposedBean.class);

		//pobaw sie, dodaj kilka wlasnych beanow, poskladaj je ze soba w zlozone struktury
		
		//zauwaz ze beany domyslnie sa tworzone w jednej instancji dla calego kontekstu
		System.out.println(composed.getSimple() == simple);
		
		//sprobuj dodac w³asne klasy konfiguracji tworzace twoje wlasne beany i dodac je do apliacji
		
		//sprobuj dodac beana ktory w konstruktorze otrzyma wartosc z propertisow
		
		//dodaj metody @PostConstruct do beanow z zaleznosciami wstrzykiwanymi przez setter i zobacz kiedy pojawiaja sie zaleznosci
		
	}
}






















































//https://stackoverflow.com/questions/4203302/how-to-inject-a-value-to-bean-constructor-using-annotations