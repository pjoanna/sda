package basics;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-06.
 */
public class Name {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = new String();

        System.out.println("Proszę podać imię: ");
        name = scanner.next();

        System.out.println("Podane imię to "+name);
    }


}
