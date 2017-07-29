package parse.array;

import java.util.List;
import java.util.Scanner;

/**
 * Created by RENT on 2017-07-29.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj tablicę w formacie [(liczba1),(liczba2),...]");

        String array = scanner.nextLine();
        try {
            List<Integer> list = MyParseArray.parseList(array);
            double mean = Statistic.mean(list);

            System.out.println("Podane liczby to: "+list);
            System.out.println("Ich średnia wynosi: "+ mean);
        }catch (IllegalArgumentException e){
            System.err.println("Zły format tablicy (" + e.getMessage() + ")");

        }

    }
}
