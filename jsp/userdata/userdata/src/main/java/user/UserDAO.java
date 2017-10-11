package user;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

//@Slf4j
public class UserDAO {

	private static final Map<Integer, User> users = new HashMap<>();

	static {
		User user1 = new User("Rafos");
		user1.setId(1);
		users.put(user1.getId(), user1);
		User user2 = new User("Admin");
		user2.setId(3);
		users.put(user2.getId(), user2);
	}

	public Optional<User> getUserById(int id) {
		return Optional.ofNullable(users.get(id));
	}

	public Set<User> getAll() {
		return new HashSet<>(users.values());
	}

	public boolean addUser(int id, String name) {
		if (users.containsKey(id)) {
		//	log.error("User o id=? już istnieje!", id);
			return false;
		}
		User user = new User(name);
		user.setId(id);
		users.put(id, user);
		return true;
	}


	public boolean removeUser(int id) {
		if (!users.containsKey(id)) {
		//	log.error("User o id=" + id + " nie istnieje!");
			return false;
		}
		users.remove(id);
		return true;
	}

	public boolean editUser(int id, String name){
		if (!users.containsKey(id)){
			return false;
		}
		User user = users.get(id);
		user.setName(name);
		return true;
	}
}
