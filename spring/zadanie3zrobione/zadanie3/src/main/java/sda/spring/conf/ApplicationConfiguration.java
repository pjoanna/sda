package sda.spring.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import sda.spring.beans.Address;
import sda.spring.beans.ComposedBean;
import sda.spring.beans.ConstructorInjected;
import sda.spring.beans.SimpleBean;
import sda.spring.beans.User;
import sda.spring.beans.WorkClass;

@Configuration
@PropertySource("application.properties")
public class ApplicationConfiguration {
	
	@Value("${simple.value}")
	private String val;
	
	@Bean
	public SimpleBean simpleBean(){
		SimpleBean simpleBean = new SimpleBean();
		simpleBean.setValue(val);
		return simpleBean;
	}
	
	@Bean(name="composed")
	public ComposedBean composedBean(){
		ComposedBean composed = new ComposedBean();
		composed.setSimple(simpleBean());
		return composed;
	}
	
	@Bean
	public ConstructorInjected constructorInjected(){
		return new ConstructorInjected(simpleBean());
	}
	
	@Bean(name="address")
	public Address address(){
		Address address = new Address();
		address.setCity("Gdansk");
		address.setCountry("Polska");
		address.setStreet("Grunwaldzka");
		address.setZipCode("80-000");
		return address;
	}
	
	@Bean(name="workAddress")
	public Address workAddress(){
		Address address = new Address();
		address.setCity("Gdynia");
		address.setCountry("Polska");
		address.setStreet("Grunwaldzka");
		address.setZipCode("80-000");
		return address;
	}
	
	@Bean
	public User user(){
		User user = new User();
		user.setAddress(address());
		user.setWorkAddress(workAddress());
		return user;
	}

	@Bean
	public WorkClass workClass(){
		WorkClass workClass = new WorkClass();
		List<User> users = new ArrayList<>();
		users.add(user());
		workClass.setUsers(users);
		return workClass;
	}

}
