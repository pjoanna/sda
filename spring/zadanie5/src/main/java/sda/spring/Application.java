package sda.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import sda.spring.beans.SimpleBean;

import java.time.LocalDate;


public class Application {

	public static void main(String[] args) {
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("'Hello World'.concat('!')");
		
		String message = (String) exp.getValue();
		
		System.out.println(message);
		
		exp = parser.parseExpression("'Hello World'.bytes.length");
		int length = (Integer) exp.getValue();
		
		System.out.println(length);

		LocalDate tomorrow = LocalDate.now().plusDays(1);
		System.out.println("Tomorrow: "+tomorrow.toString());

		exp = parser.parseExpression(tomorrow.toString());
		LocalDate tomorrow2 = (LocalDate) exp.getValue();
        System.out.println("Tomorrow2: "+tomorrow2.toString());

		//sprobuj pobawic sie parserem, zobacz co mozna zrobic, w linku na gorze jest wiele ciekawych przykladow

		
		//spel mozna wykorzystywac to ustawiania wartosci beanow
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");

		SimpleBean simple = applicationContext.getBean(SimpleBean.class);

		System.out.println(simple.getValue());
		
		//sprobuj stworzyc beana ktoremu w polu ustawimy czas aktualny + 1 dzien
		//sprobuj stworzyc beana ktoremu w polu ustawimy wartosc 10 + losowa liczba
	}
}
