package sda.spring.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import sda.spring.model.Login;
import sda.spring.model.User;

@Service
public class UserDaoImpl implements UserDao {

	private ConcurrentHashMap<String, User> data = new ConcurrentHashMap<>();

	public void register(User user) {
		data.put(user.getUsername(), user);
	}

	public User validateUser(Login login) {
		User user = data.get(login.getUsername());
		return user;
	}
}

