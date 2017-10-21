package sda.spring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sda.spring.model.LoginDto;
import sda.spring.model.User;
import sda.spring.model.UserDto;
import sda.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void register(User user) {
		userRepository.save(user);
	}

	public User validateUser(LoginDto login) {
		return userRepository.findByUsername(login.getUsername());
	}

	@Override
	public User findUser(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public List<User> findByPassword(String username) {
		return userRepository.findByPassword(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findUser(username);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, mapRoles(user));
	}

	private Collection<GrantedAuthority> mapRoles(User user) {
		List<GrantedAuthority> roles = new ArrayList<>();
		if (user.getUsername().equals("anna"))
			roles.add(new SimpleGrantedAuthority("kursant"));
		return roles;
	}
}

