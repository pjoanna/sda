package sda.spring;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import sda.spring.beans.*;

//http://www.mkyong.com/spring/spring-propertyplaceholderconfigurer-example/

public class Application {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");

		SimpleBean simple = applicationContext.getBean(SimpleBean.class);

		MyBean myBean = (MyBean) applicationContext.getBean("myBean");
		System.out.println(simple.getValue());
		System.out.println(myBean.getText());

		MergingBean mergingBean = (MergingBean) applicationContext.getBean("mergingBean");

		MyBeanPostProcessor myBeanPostProcessor = new MyBeanPostProcessor();
		myBeanPostProcessor.postProcessBeforeInitialization(mergingBean, "mergingBean");
		myBeanPostProcessor.postProcessAfterInitialization(mergingBean, "mergingBean");
		//pobaw sie troche, sprobuj dodac beany ktore beda otrzymywac inne typy danych jako parametry, zobacz co mozna przekazac propertisem a co nie bardzo
		
		//sprobuj dodac bean post processor http://www.concretepage.com/spring/example_beanpostprocessor_spring
		
		//popatrz w mozliwe opcje w xmlu na tagu bean i ustal kolejnosc tworzenia beanow, sprobuj popsuc aplikacje stosujac rozne warianty opcji depends-on
	}
}
