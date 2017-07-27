

package mutability.person;

/**
 * Created by RENT on 2017-07-22.
 */
public class PersonExample {

    public static void main(String[] args) {
        Person a = new Person("Jan", "Kowalski");
        Person b = new Person("Jan", "Kowalski");

        System.out.println(a == b); //  false
        System.out.println(a.equals(b)); // true

        b = b.changeName("Adam");
        System.out.println(a == b); // false // zmiana imienia obiektu b - a i b nie są już równe equalsem
        System.out.println(a.equals(b)); // false
        a = b; // a wskazuje na to samo co b
        System.out.println(a == b); // true
        System.out.println(a.equals(b)); // true
        a = a.changeName("Paweł");  // b = b+ 9, tworzony jest nowy obiekt
                                    // za pomocą kopii a i zmiany imeinia na Paweł = Paweł Kowalski
        b = b.changeSurname("Nowak"); // podobnie  jak wyżej  - dostajemy Adam Nowak
        System.out.println(a == b);  // false
        System.out.println(a.equals(b)); // false
        System.out.println(a); // Paweł Kowalski
        System.out.println(b); // Adam Nowak


//
//        String s = "cos";
//        s.toUpperCase(); // to nic nie robi
//        System.out.println(s);
//        s = s.toUpperCase();
//        System.out.println(s);

    }
}
