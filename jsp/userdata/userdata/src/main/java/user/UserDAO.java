package user;

import database.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.*;

//@Slf4j
public class UserDAO {

    private static final Map<Integer, User> users = new LinkedHashMap<>();

    SessionFactory sessionFactory;
    Session session;

    public UserDAO() {
        this.sessionFactory= HibernateUtil.getSessionFactory();
    }

    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory=sessionFactory;
    }

//	static {
//
//		User user1=new User( "Rafos");
//		User user2=new User( "Admin");
//		users.put(user1.getId(), user1);
//		users.put(user2.getId(), user2);
//	}

    public Optional<User> getUserById(int id) {
        return Optional.of(users.get(id));
    }

    public Set<User> getAll() {

        session=sessionFactory.openSession();
        try {
            session.beginTransaction();

            List<User> usersList = (List<User>) session.createQuery("from User")
                    .getResultList();
            users.clear();
            for (User u : usersList) {
                users.put(u.getId(), u);
            }
            session.getTransaction().commit();
        } catch (Throwable e) {
            System.out.println("ROLLBACK");
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();

        }

        session.close();
        return new LinkedHashSet<>(users.values());
    }

    public int addUser(String name) {

        int idToReturn=0;

        session=sessionFactory.openSession();
        try {
            session.beginTransaction();

            User user = new User(name);


            session.persist(user);
            session.getTransaction().commit();
            idToReturn=user.getId();

        } catch (Throwable e) {
            System.out.println("ROLLBACK");
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        session.close();
        return idToReturn;
    }

    public boolean removeUser(int id) {
        if (!users.containsKey(id)) {
            //		log.error("User o id=" + id + " nie istnieje!");
            return false;
        }
        session=sessionFactory.openSession();
        try {
            session.beginTransaction();

            User user = session.find(User.class, id);
            session.delete(user);
//			session.createQuery("delete from User where id= :id")
//					.setParameter("id", id)
//					.executeUpdate();

            session.getTransaction().commit();

        } catch (Throwable e) {
            System.out.println("ROLLBACK");
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        session.close();
        return true;
    }

    public boolean editUser (User user){
        if (!users.containsKey(user.getId())) {
            //		log.error("User o id=" + id + " nie istnieje!");
            return false;
        }
        session=sessionFactory.openSession();


        try {

            session.beginTransaction();

            User userToUpdate = session.find(User.class, user.getId());
            userToUpdate.setName(user.getName());
            session.save(userToUpdate);
            session.getTransaction().commit();

        } catch (Throwable e) {
            System.out.println("ROLLBACK");
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        session.close();
        return true;
    }
}
