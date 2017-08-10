package abstractfactory.person;

import java.util.Scanner;

/**
 * Created by RENT on 2017-08-09.
 */
public class PersonCreator {

    public static Person createPerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imię: ");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko: ");
        String surname = scanner.nextLine();
        System.out.println("podaj numer indeksu: ");
        Long index = Long.parseLong(scanner.nextLine());
        return new Person(name,surname,index);
    }
}
