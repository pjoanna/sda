package sda.spring.service;

import sda.spring.model.Login;
import sda.spring.model.User;

public interface UserDao {
	
	void register(User user);

	User validateUser(Login login);
}