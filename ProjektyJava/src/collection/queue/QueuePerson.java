package collection.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by RENT on 2017-07-18.
 */
public class QueuePerson {
    public static void main(String[] args) {
        Queue<Person> people = new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }   //od new Comparator dotąd mamy klasę anonimwą (wyrażenie lambda) -
                // występuje tylko raz i nie ma nazwy  - rodzaj klasy wewnętrznej
        });

        Person[] people1 = {
                new Person("Asia", 27),
                new Person("Natalia", 20),
                new Person("Adam", 30),
                new Person("Dziadek", 75)
        };

        for (Person person : people1) {
            people.offer(person);
        }
        while (people.size() > 0){
            System.out.println(people.poll().getName()); //dopóki ktoś stoi wyciągamy elementy
        }

    }

}
