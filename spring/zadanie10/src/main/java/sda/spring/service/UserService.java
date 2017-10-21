package sda.spring.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import sda.spring.model.LoginDto;
import sda.spring.model.User;

public interface UserService extends UserDetailsService {
	
	void register(User user);

	User validateUser(LoginDto login);

	User findUser(String username);

	List<User> findByPassword(String password);
}