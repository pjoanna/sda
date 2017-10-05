import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 * Created by pjoanna on 2017-10-02.
 */
public class Application {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();



            session.getTransaction().commit();
        } catch (Throwable e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
