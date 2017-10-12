package user;

import database.HibernateUtil;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;

//@Slf4j
public class UserDAO {

	private static final Map<Integer, User> users = new HashMap<>();
    SessionFactory sessionFactory;
    Session session;

	public UserDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
//
//	static {
////		User user1 = new User("Rafos");
////		user1.setId(1);
////		users.put(user1.getId(), user1);
////		User user2 = new User("Admin");
////		user2.setId(3);
////		users.put(user2.getId(), user2);
//	}

	public Optional<User> getUserById(int id) {
		return Optional.ofNullable(users.get(id));
	}

	public Set<User> getAll() {
	    session = sessionFactory.openSession();

	    try {
            session.beginTransaction();
            List<User> userList = (List<User>) session.createQuery("from User").getResultList();
            users.clear();
            for (User user : userList) {
                users.put(user.getId(), user);
            }

            session.update(users);
            session.getTransaction().commit();
        }catch (Throwable e){
            System.out.println("rollback");
            session.getTransaction().rollback();
            e.printStackTrace();

        }finally {
            session.close();
        }
        session.close();
     //   sessionFactory.close();

		return new HashSet<>(users.values());
	}

	public boolean addUser(int id, String name) {

	    session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            User user = new User(name);
            user.setId(id);
            users.put(id, user);

            session.save(user);
           // session.persist(user);
            session.getTransaction().commit();

        }catch (Throwable e){
            System.out.println("rollback");
            session.getTransaction().rollback();
            e.printStackTrace();
            session.close();
            return false;
        }finally {
            session.close();
        }
        session.close();
  //      sessionFactory.close();

        return  true;

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
