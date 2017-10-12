package sda.spring.conf;

import com.oracle.webservices.internal.api.message.PropertySet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sda.spring.beans.*;

@Configuration
public class ApplicationConfiguration {
	
	@Bean(name = "simple")
	public SimpleBean simpleBean(){
		return new SimpleBean();
	}
	
	@Bean(name="composed")
	public ComposedBean composedBean(){
		ComposedBean composed = new ComposedBean();
		composed.setSimple(simpleBean());
		return composed;
	}
	
	@Bean(name = "injected")
	public ConstructorInjected constructorInjected(){
	    SimpleBean simpleBean = simpleBean();
	    simpleBean.setValue("lol");
		return new ConstructorInjected(simpleBean);
	}

	@Bean
	public MyBean myBean(){
		return new MyBean();
	}

	@Bean(name = "address")
    public Address address(){
	    return new Address("street", 21, "city");
    }

    @Bean(name = "user")
    public User user(){
        return new User("name", 21, address());
    }

}
