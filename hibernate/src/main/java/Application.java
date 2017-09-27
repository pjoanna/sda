import onetoonemappedby.Address1;
import onetoonemappedby.Customer1;
import onetoonepk.Human;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 * Created by RENT on 2017-09-25.
 */
public class Application {

    public static void main(String[] args) {

 //////////kod do pakietu onetoonemappedby - dwukierunkowa
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();


            Address1 address1 = new Address1("Długa", "Gdańsk", "---");
            Customer1 customer1 = new Customer1("lastname","firstname", 200, address1);

            customer1.setAddress1(address1);
            address1.setCustomer1(customer1);

            session.persist(address1);
            session.persist(customer1);

            Customer1 customer11 = session.find(Customer1.class, 1);
            System.out.println(customer11.toString());

            session.getTransaction().commit();
        } catch (Throwable e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

//////////kod do pakietu onetoonepk
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        try {
//            session.beginTransaction();
//
////            Brain brain = new Brain(413);
////            session.persist(brain);
////
////            Human human = new Human("smieszek", brain);
////            human.setId(brain.getId());
////            session.persist(human);
//
//            Human human1 = session.find(Human.class, 1);
//            System.out.println(human1.toString());
//
//            session.getTransaction().commit();
//        } catch (Throwable e) {
//            session.getTransaction().rollback();
//        } finally {
//            session.close();
//            sessionFactory.close();
//        }
//    }


///////// kod do pakietu onetoone
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        try {
//            session.beginTransaction();
//
//            Address1 address = new Address1("Długa", "Gdańsk", "---");
//            session.persist(address);
//
//            Customer1 customer = new Customer1("lastname","firstname", 200, address);
//            session.persist(customer);
//            //
//
//            session.getTransaction().commit();
//        } catch (Throwable e) {
//            session.getTransaction().rollback();
//        } finally {
//            session.close();
//            sessionFactory.close();
//        }
//    }


////////////////////////////// kod do pakietu domain :P

//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); //fabryka sesji
//        Session session = sessionFactory.openSession(); // sesja
//        Transaction transaction = session.beginTransaction();// transakcja

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

//        Person person0 = new Person("person1", 23, 3200.0, "jakiśString", new Date(), new Date(), Size.SIZE1, WorkerType.WORKER_TYPE1);
//        Person person1 = new Person("person2", 45, 4200.0, "jakiśString2", new Date(), new Date(), Size.SIZE2, WorkerType.WORKER_TYPE2);
//
//        session.persist(person0);
//        session.persist(person1);
//
//        Person personFromBase = session.find(Person.class, 1);
//
//        System.out.println(personFromBase.toString());
//
//        personFromBase = session.find(Person.class, 2);
//        personFromBase.setPersonAge(66);
//        session.save(personFromBase);
//
//        System.out.println(personFromBase.toString());
//
//        session.remove(personFromBase);
//
//        transaction.commit();  // commitowanie
//        session.close(); //zamykanie sesji
//        sessionFactory.close(); // zamykanie fabryki

//}
}
