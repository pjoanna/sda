package mutability;

/**
 * Created by RENT on 2017-07-22.
 */
public class PersonExample {

    public static void main(String[] args) {
        Person a = new Person("Jan", "Kowalski");
        Person b = new Person("Jan", "Kowalski");

        System.out.println(a == b); // false - nie korzysta z equals -  różne miejsca w pamięci
        System.out.println(a.equals(b)); // true - korzysta z equals

        b.setName("Adam");

        System.out.println(a == b); // false
        System.out.println(a.equals(b)); // false - różne imiona

        a = b; // wskazujemy na to samo

        System.out.println(a == b); // true
        System.out.println(a.equals(b)); // true

        a.setName("Paweł"); // b też ma na imię Paweł - edytujemy ten sam obiekt

        b.setSurname("Nowak"); // nazwisko a też się zmienia, bo wskazują na ten sam obiekt, a to ten obiekt się zmienia

        System.out.println(a == b); //true
        System.out.println(a.equals(b)); //true

        System.out.println(a); //Adam Nowak
        System.out.println(b); //Adam Nowak

    }
}
