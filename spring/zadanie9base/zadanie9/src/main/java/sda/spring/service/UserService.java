package sda.spring.service;

import sda.spring.model.LoginDto;
import sda.spring.model.User;
import sda.spring.model.UserDto;

public interface UserService {
	
	void register(User user);

	User validateUser(LoginDto login);
}