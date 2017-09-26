import domain.Employee;
import domain.Person;
import domain.Size;
import domain.WorkerType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.time.Instant;
import java.util.Date;

/**
 * Created by RENT on 2017-09-25.
 */
public class Application {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); //fabryka sesji
        Session session = sessionFactory.openSession(); // sesja
        Transaction transaction = session.beginTransaction();// transakcja

        //   Employee employee1 = new Employee("Heniek", "password", 43);
   //     session.persist(employee1); // persist - utrwala, nadaje id, dodaje do bazy?
//        Employee employee2 = new Employee("Janusz", "janusz02", 35);
//        session.persist(employee2);

//        Employee employee = session.find(Employee.class, 1);
//        System.out.println(employee.toString());
////        employee.setAge(23);
////        session.save(employee);
////        employee = session.find(Employee.class, 1);
////        System.out.println(employee.toString());
//        employee = session.find(Employee.class, 2); // teraz w bazie nie będzie juz rekordu o id 2
//        session.remove(employee);

        Person person0 = new Person("person1", 23, 3200.0, "jakiśString", new Date(),  new Date(), Size.SIZE1, WorkerType.WORKER_TYPE1);
        Person person1 = new Person("person2", 45, 4200.0, "jakiśString2", new Date(),  new Date(), Size.SIZE2, WorkerType.WORKER_TYPE2);

        session.persist(person0);
        session.persist(person1);

        Person personFromBase = session.find(Person.class, 1);

        System.out.println(personFromBase.toString());

        personFromBase = session.find(Person.class, 2);
        personFromBase.setPersonAge(66);
        session.save(personFromBase);

        System.out.println(personFromBase.toString());

        session.remove(personFromBase);

        transaction.commit();  // commitowanie
        session.close(); //zamykanie sesji
        sessionFactory.close(); // zamykanie fabryki

    }
}
