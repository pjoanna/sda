package sda.spring.beans;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComposedBean {
	
	@Autowired
	private SimpleBean simple;

	public SimpleBean getSimple() {
		return simple;
	}

	public void setSimple(SimpleBean simple) {
		this.simple = simple;
	}
	
	
	@PostConstruct
	public void init(){
		System.out.println("ConstructorInjected created");
	}

}
