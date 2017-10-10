package pl.sdacademy.user;

import java.util.Date;
import java.util.Optional;

public class UserDAO {

	public Optional<User> getUserById(int id) {
		// tutaj bedzie wyciaganie usera z bazy
		return Optional.of(new User(id, "jakis nick", "haslo", new Date(), Gender.MALE, "moj super opis"));
	}

	public Optional<User> getUserByNickName(String nickName) {
		Optional<User> empty = Optional.empty();
		return empty;
	}
}
