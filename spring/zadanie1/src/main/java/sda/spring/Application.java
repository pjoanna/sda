package sda.spring;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import sda.spring.beans.ComposedBean;
import sda.spring.beans.MyBean;
import sda.spring.beans.SimpleBean;
import sda.spring.beans.Three;

//https://www.springbyexample.org/examples/intro-to-ioc-creating-a-spring-application.html

public class Application {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");

		SimpleBean simple = applicationContext.getBean(SimpleBean.class);

		System.out.println(simple.getValue());
		
		ComposedBean composed = (ComposedBean) applicationContext.getBean("composed");

		System.out.println(composed.getSimple().getValue());

		MyBean myBean = (MyBean) applicationContext.getBean("myBean");


		Three three = (Three) applicationContext.getBean("three");
		System.out.println(three);
		//pobaw sie, dodaj kilka wlasnych beanow, poskladaj je ze soba w zlozone struktury
		
		//zauwaz ze beany domyslnie sa tworzone w jednej instancji dla calego kontekstu
		System.out.println(composed.getSimple() == simple);

		//sprobuj dodac innego beana typu SimpleBean, czy jest ta sama instancja co simple?
		
		//jak stworzonego przez ciebie SimpleBean wstrzyknac do composed zamiast domyslnego?

        //sprobuj stworzyc 2 beany ktore beda mialy relacje do siebie nawzajem korzystajac z wstrzykiwania przez setter (jak w ComposedBean)
		
		//sprobuj stworzyc 2 beany ktora beda mialy relacje do siebie nawzajem korzystajac z wstrzykiwania przez konstruktor (jak w ConstructorInjected)
		
		//sprobuj stworzyc fabryke beanow http://www.baeldung.com/spring-factorybean

	}
}
