package sda.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructorInjected {
	
	private SimpleBean simple;

	@Autowired
	public ConstructorInjected(SimpleBean simple) {
		super();
		this.simple = simple;
	}

	public SimpleBean getSimple() {
		return simple;
	}

}
