import domain.Employee;
import domain.Person;
import domain.Size;
import domain.WorkerType;
import many2many.Attraction;
import many2many.Town;
import manytoone.Animal;
import manytoone.Owner;
import myexamples.onetoone.Course;
import myexamples.onetoone.Student;
import onetomany.Phone;
import onetomany.User;
import onetoonemappedby.Address1;
import onetoonemappedby.Customer1;
import onetoonepk.Human;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by RENT on 2017-09-25.
 */
public class Application {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
//            domainEx1(session);
//            onetoonepkEx1(session);
//            createOneToManyEx1(session);
//            oneToOneMappedByEx1(session);
//            onetomanyEx1(session);
//            addRowsToAnimalAndOwner(session);
//            addRowsToAttractionAndTown(session);
//            showAttractionsForTown(session);

            Student student = new Student("robert",21);
            Student student1 = new Student("fhek", 34);


            Course course = new Course();


            session.getTransaction().commit();
        } catch (Throwable e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    private static void showAttractionsForTown(Session session) {
        Town town = session.find(Town.class, 3);
        Set<Attraction> attractions = town.getAttractions();

        for (Attraction attraction : attractions) {
            System.out.println(attraction.toString());
        }

        System.out.println();
    }

    private static void addRowsToAttractionAndTown(Session session) {
        Attraction attraction1 = new Attraction("att1","park1");
        Attraction attraction2 = new Attraction("att2","park2");
        Attraction attraction3 = new Attraction("att3","park3");
        Attraction attraction4 = new Attraction("att4","park4");

        Town town1 = new Town("town1", "country1");
        Town town2 = new Town("town2", "country2");
        Town town3 = new Town("town3", "country4");
        Town town4 = new Town("town4", "country4");

        town1.getAttractions().add(attraction1);
        town1.getAttractions().add(attraction2);
        town2.getAttractions().add(attraction3);
        town2.getAttractions().add(attraction4);
        town3.getAttractions().add(attraction1);
        town3.getAttractions().add(attraction2);
        town4.getAttractions().add(attraction3);
        town4.getAttractions().add(attraction4);

        attraction1.getTowns().add(town1);
        attraction2.getTowns().add(town1);
        attraction1.getTowns().add(town3);
        attraction2.getTowns().add(town3);
        attraction3.getTowns().add(town2);
        attraction4.getTowns().add(town2);
        attraction3.getTowns().add(town4);
        attraction4.getTowns().add(town4);

        session.persist(attraction1);
        session.persist(attraction2);
        session.persist(attraction3);
        session.persist(attraction4);
        session.persist(town1);
        session.persist(town2);
        session.persist(town3);
        session.persist(town4);
    }

    private static void addRowsToAnimalAndOwner(Session session) {
        Animal animal1 = new Animal("pppp", "2231");
        Animal animal2 = new Animal("eeee", "243");
        Animal animal3 = new Animal("rrrr", "113424");
        Animal animal4 = new Animal("tttt", "5343");
        Owner owner1 = new Owner("nameOwner0", 93);
        Owner owner2 = new Owner("nameOwner1", 23);

        owner1.getAnimals().add(animal1);
        owner1.getAnimals().add(animal2);
        owner2.getAnimals().add(animal3);
        owner2.getAnimals().add(animal4);

        animal1.setOwner(owner1);
        animal2.setOwner(owner1);
        animal3.setOwner(owner2);
        animal4.setOwner(owner2);

        session.persist(owner1);
        session.persist(owner2);
        session.persist(animal1);
        session.persist(animal2);
        session.persist(animal3);
        session.persist(animal4);
    }

    private static void onetomanyEx1(Session session) {
        //            List<User> users = (List<User>) session.createQuery("from User").getResultList();
//
//            System.out.println(users.toString());
//            one2oneEx1(session);

//
//            List<Phone> phones = (List<Phone>) session.createQuery("from Phone p where p.number = :number")
//                    .setParameter("number", "9876543321")
//                    .getResultList();
//
//            System.out.println(phones);


//            List<User> users = (List<User>) session.createQuery("select u from User u join u.phones p where p.number = :number")
//                    .setParameter("number", "123456789")
//                    .getResultList();
//            System.out.println(users);

//            User user = new User("Janusz");
//            session.persist(user);

        List<User> users = (List<User>) session.createQuery("select u from User u left join u.phones p where p is null").getResultList();

        System.out.println(users);
    }

    private static void domainEx1(Session session) {
        //////////////////////////// kod do pakietu domain :P
        Employee employee1 = new Employee("Heniek", "password", 43);
        session.persist(employee1); // persist - utrwala, nadaje id, dodaje do bazy?
        Employee employee2 = new Employee("Janusz", "janusz02", 35);
        session.persist(employee2);

        Employee employee = session.find(Employee.class, 1);
        System.out.println(employee.toString());
//        employee.setAge(23);
//        session.save(employee);
//        employee = session.find(Employee.class, 1);
//        System.out.println(employee.toString());
        employee = session.find(Employee.class, 2); // teraz w bazie nie będzie juz rekordu o id 2
        session.remove(employee);

        Person person0 = new Person("person1", 23, 3200.0, "jakiśString", new Date(), new Date(), Size.SIZE1, WorkerType.WORKER_TYPE1);
        Person person1 = new Person("person2", 45, 4200.0, "jakiśString2", new Date(), new Date(), Size.SIZE2, WorkerType.WORKER_TYPE2);

        session.persist(person0);
        session.persist(person1);

        Person personFromBase = session.find(Person.class, 1);

        System.out.println(personFromBase.toString());

        personFromBase = session.find(Person.class, 2);
        personFromBase.setPersonAge(66);
        session.save(personFromBase);

        System.out.println(personFromBase.toString());

        session.remove(personFromBase);


    }

    private static void one2oneEx1(Session session) {
        /////// kod do pakietu onetoone

        Address1 address = new Address1("Długa", "Gdańsk", "---");
        session.persist(address);

        Customer1 customer = new Customer1("lastname", "firstname", 200, address);
        session.persist(customer);
        //

        session.getTransaction().commit();
    }

    private static void onetoonepkEx1(Session session) {
        ////////kod do pakietu onetoonepk
//            Brain brain = new Brain(413);
//            session.persist(brain);
//
//            Human human = new Human("smieszek", brain);
//            human.setId(brain.getId());
//            session.persist(human);

        Human human1 = session.find(Human.class, 1);
        System.out.println(human1.toString());

        session.getTransaction().commit();
    }

    private static void oneToOneMappedByEx1(Session session) {
        //////////kod do pakietu onetoonemappedby - dwukierunkowa
        Address1 address1 = new Address1("Długa", "Gdańsk", "---");
        Customer1 customer1 = new Customer1("lastname", "firstname", 200, address1);

        customer1.setAddress1(address1);
        address1.setCustomer1(customer1);

        session.persist(address1);
        session.persist(customer1);

        Customer1 customer11 = session.find(Customer1.class, 1);
        System.out.println(customer11.toString());

        session.getTransaction().commit();
    }

    private static void createOneToManyEx1(Session session) {
        // one to many
        User user1 = new User("mietek");
        User user2 = new User("heniek");

        Phone phone1 = new Phone("123456789", "nokia");
        Phone phone2 = new Phone("9876543321", "huawei");
        Phone phone3 = new Phone("9876543321", "lg");

        session.persist(phone1);
        session.persist(phone2);
        session.persist(phone3);

        user1.getPhones().add(phone1);
        user1.getPhones().add(phone2);
        user2.getPhones().add(phone3);

        session.persist(user1);
        session.persist(user2);
    }


//        session.close(); //zamykanie sesji
//        sessionFactory.close(); // zamykanie fabryki

//}
}
