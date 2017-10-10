package user;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class UserDAO {

	private static final Map<Integer, User> users = new HashMap<>();

	static {
		users.put(1, new User(1, "Rafos"));
		users.put(3, new User(3, "Admin"));
	}

	public Optional<User> getUserById(int id) {
		return Optional.ofNullable(users.get(id));
	}

	public Set<User> getAll() {
		return new HashSet<>(users.values());
	}

	public boolean addUser(int id, String name) {
		if (users.containsKey(id)) {
			log.error("User o id=? już istnieje!", id);
			return false;
		}
		users.put(id, new User(id, name));
		return true;
	}

	public boolean removeUser(int id) {
		if (!users.containsKey(id)) {
			log.error("User o id=" + id + " nie istnieje!");
			return false;
		}
		users.remove(id);
		return true;
	}
}
