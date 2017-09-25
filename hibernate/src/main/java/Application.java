import domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 * Created by RENT on 2017-09-25.
 */
public class Application {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); //fabryka sesji
        Session session = sessionFactory.openSession(); // sesja
        session.beginTransaction(); // transakcja

        Employee employee = session.find(Employee.class, 23);
        System.out.println("Employee " + employee);


        session.getTransaction().commit(); // commitowanie
        session.close(); //zamykanie sesji
        sessionFactory.close(); // zamykanie fabryki



    }
}
