package sda.spring.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import sda.spring.model.LoginDto;
import sda.spring.model.UserDto;

@Service
public class UserDaoImpl implements UserDao {


	private ConcurrentHashMap<String, UserDto> data = new ConcurrentHashMap<>();

	public void register(UserDto user) {
		data.put(user.getUsername(), user);
	}

	public UserDto validateUser(LoginDto login) {
		UserDto user = data.get(login.getUsername());
		return user;
	}

	@Override
	public UserDto getUserDto(String login) {
		return data.get(login);
	}
}

