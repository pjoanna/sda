package user;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import database.HibernateUtil;

//@Slf4j
public class UserDAO {

    private static UserDAO ourInstance = new UserDAO();

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session = sessionFactory.openSession();

    private UserDAO() {
    }

    @Override
    protected void finalize() throws Throwable {
        session.close();
    }

    public static UserDAO getInstance() {
        return ourInstance;
    }

    public Optional<User> getUserById(int id) {

        Transaction tr = session.beginTransaction();
        User user = session.get(User.class, id);

        Optional<User> userOptional = Optional.ofNullable(user);

        tr.commit();
        return userOptional;
    }

    public Set<User> getAll() {
        Transaction tr = session.beginTransaction();
        String hql = "FROM User";
        Query query = session.createQuery(hql);
        List<User> results = query.list();

        Set<User> returned = new HashSet<>(results);

        tr.commit();
        return returned;
    }

    public Optional<User> addUser(String name) {
        Transaction tr = session.beginTransaction();
        User user = new User(name);
        Integer employeeID = (Integer) session.save(user);
        tr.commit();
        return getUserById(employeeID);
    }

    public boolean removeUser(int id) {
        Transaction tr = session.beginTransaction();
        Optional<User> userById = getUserById(id);
        if (!userById.isPresent()) {
            return false;
        }
        session.delete(userById.get());
        tr.commit();
        return true;
    }
}