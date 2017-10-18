package sda.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sda.spring.model.LoginDto;
import sda.spring.model.User;
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
}

