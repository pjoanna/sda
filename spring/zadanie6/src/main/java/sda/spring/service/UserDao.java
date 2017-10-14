package sda.spring.service;

import sda.spring.model.Login;
import sda.spring.model.User;

public interface UserDao {
	
	String register(User user);

	boolean validateUser(Login login);

	User getUser(String login);
}