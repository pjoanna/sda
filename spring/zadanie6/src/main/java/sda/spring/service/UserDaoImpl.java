package sda.spring.service;

import java.util.concurrent.ConcurrentHashMap;

import org.h2.util.StringUtils;
import org.springframework.stereotype.Service;

import sda.spring.model.Login;
import sda.spring.model.User;

@Service
public class UserDaoImpl implements UserDao {

	private ConcurrentHashMap<String, User> data = new ConcurrentHashMap<>();

	public String register(User user) {
		StringBuilder errors = new StringBuilder();
		if (StringUtils.isNullOrEmpty(user.getUsername())){
			errors.append("Username missing");
		}
		if (StringUtils.isNullOrEmpty(user.getPassword())){
			errors.append("Password missing");
		}
		if (StringUtils.isNullOrEmpty(user.getFirstname())){
			errors.append("Firstname missing");
		}
		if (StringUtils.isNullOrEmpty(user.getLastname())){
			errors.append("Lastname missing");
		}
		if (StringUtils.isNullOrEmpty(user.getEmail())){
			errors.append("Email missing");
		}
		if (StringUtils.isNullOrEmpty(user.getAddress())){
			errors.append("Address missing");
		}
		String errorMsg =errors.toString();
		if(StringUtils.isNullOrEmpty(errorMsg) && data.get(user.getUsername()) == null){
			data.put(user.getUsername(), user);
			return null;
		}
		return errorMsg;
	}

	public boolean validateUser(Login login) {
		User user = data.get(login.getUsername());
		if(user == null){
			return false;
		}
		if(user.getPassword().equals(login.getPassword())){
			return true;
		}
		return false;
	}

	@Override
	public User getUser(String login) {
		return data.get(login);
	}
}

