package sda.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sda.spring.model.LoginDto;
import sda.spring.model.User;
import sda.spring.repository.UserRepository;

import java.util.List;

				// Krok 5.
				// Dodajemy koniecznie @Service nad nazwą klasy
				// Implementujemy interfejs UserService
				// Wstrzykujemy intefejs UserRepository za pomocą @Autowired


@Service
public class UserServiceImpl implements UserService {

	@Autowired  	// Wstrzykujemy intefejs UserRepository
	private UserRepository userRepository;

	// Ta jedna metoda poniżej nie dotyczy wczorajszych zajęć i nie wiem za bardzo o co chodzi z tym validate
	public User validateUser(LoginDto login) {

		return userRepository.findByUsername(login.getUsername());
	}

	@Transactional
	public void register(User user) {

		userRepository.save(user);
		// save (domyślna metoda userRepository) sprawi, że zapiszemy obiekt user jako wiersz do bazy danych
		// save to metoda domyślna, dlatego nie wpisywaliśmy jej sami ręcznie w userRepository
	}

	@Override
	public List<User> findByPassword(String password) {

		return userRepository.findByPassword(password);  // tu używamy metody, którą napisaliśmy w userRepository
	}

	@Override
	public List<User> findByFirstnameAndPassword(String firstName, String password) {
		return userRepository.findByFirstnameAndPassword(firstName, password);  // tu używamy metody, którą napisaliśmy w userRepository
	}



	// -> następnie trzeba stworzyć te metody w Controllerze idź do UserController
}

