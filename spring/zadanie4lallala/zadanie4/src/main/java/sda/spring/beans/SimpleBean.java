package sda.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("simple")
public class SimpleBean {
	
	private String value;

	public SimpleBean(@Value("${simple.value}") String value, @Value("${simple.value}") String value2) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
