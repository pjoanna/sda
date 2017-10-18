package sda.spring.service;

import sda.spring.model.LoginDto;
import sda.spring.model.User;
import sda.spring.model.UserDto;

import java.util.List;

public interface UserService {
	
	void register(User user);
	User validateUser(LoginDto login);
	// te dwie metody powyżej dotyczą samego swaggera, nie bazy danych co opisuję w tych komentarzach


	// Krok 4.
	// Tworzymy tu takie same metody jak UserRepository

	List<User> findByPassword(String password);
	List<User> findByFirstnameAndPassword (String firstName, String password);


	// -> przechodzimy do UserServiceImpl i importujemy te metody
}