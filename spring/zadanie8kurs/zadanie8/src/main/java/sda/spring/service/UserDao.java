package sda.spring.service;

import sda.spring.model.LoginDto;
import sda.spring.model.UserDto;

public interface UserDao {
	
	void register(UserDto user);

	UserDto validateUser(LoginDto login);

	UserDto findUser(String username);
}