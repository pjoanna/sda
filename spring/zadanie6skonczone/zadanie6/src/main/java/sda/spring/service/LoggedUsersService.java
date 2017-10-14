package sda.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import sda.spring.model.User;

@Service
public class LoggedUsersService {

	private Map<String, User> loggedinUsers = new ConcurrentHashMap<>();
	
	public void userLogin(User user){
		this.loggedinUsers.put(user.getUsername(), user);
	}
	
	public void userLogout(User user){
		this.loggedinUsers.remove(user.getUsername());
	}
	
	public List<User> getLoggedInUsers(){
		return new ArrayList<>(this.loggedinUsers.values());
	}
	
	
}
