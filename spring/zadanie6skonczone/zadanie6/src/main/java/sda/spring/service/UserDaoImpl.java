package sda.spring.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import sda.spring.model.Login;
import sda.spring.model.User;

@Service
public class UserDaoImpl implements UserDao {

	private ConcurrentHashMap<String, User> data = new ConcurrentHashMap<>();

	public String register(User user) {
		StringBuilder errors = new StringBuilder();
		if(StringUtils.isEmpty(user.getUsername())){
			errors.append("Username missing,");
		}
		if(StringUtils.isEmpty(user.getAddress())){
			errors.append("Address missing,");
		}
		if(StringUtils.isEmpty(user.getEmail())){
			errors.append("Email missing,");
		}
		if(StringUtils.isEmpty(user.getFirstname())){
			errors.append("Frist name missing,");
		}
		if(StringUtils.isEmpty(user.getLastname())){
			errors.append("Last name missing,");
		}
		if(StringUtils.isEmpty(user.getPassword())){
			errors.append("password missing,");
		}
		String errorMsg = errors.toString();
		if(StringUtils.isEmpty(errorMsg) && data.get(user.getUsername()) == null){
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

