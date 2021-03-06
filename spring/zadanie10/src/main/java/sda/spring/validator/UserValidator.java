package sda.spring.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sda.spring.model.User;
import sda.spring.model.UserDto;
import sda.spring.service.UserService;

@Component
public class UserValidator implements Validator{
	
	@Autowired
	UserService userDao;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == UserDto.class;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		if(obj instanceof UserDto){
			UserDto user = (UserDto) obj;
			User found = userDao.findUser(user.getUsername());
			if(found != null){
				errors.reject("login");
			}
		}
		
	}

}
