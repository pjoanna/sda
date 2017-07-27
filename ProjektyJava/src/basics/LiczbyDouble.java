package basics;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-08.
 */
public class LiczbyDouble {
    public static double podajLiczbe(){
        double i;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Proszę podać liczbę (typu double)");
        i = scanner.nextDouble();
        return i;
    }

    public static void main(String[] args) {
        double a, b, iloraz;
        a = podajLiczbe();
        b = podajLiczbe();
        iloraz = a/b;

        System.out.println("Iloraz podanych liczb wynosi: "+iloraz);

    }
}
