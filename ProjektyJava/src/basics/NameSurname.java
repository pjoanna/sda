package basics;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-10.
 */
public class NameSurname {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String surname;

        System.out.println("Podaj imixę i nazwisko");
        name = scanner.next();
        surname = scanner.next();

        System.out.println("Witaj "+name+" "+surname);
    }
}
