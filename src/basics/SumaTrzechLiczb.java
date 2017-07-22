package basics;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-08.
 */
public class SumaTrzechLiczb {
    public static int podajLiczbe(){
        Scanner scanner = new Scanner(System.in);
        int a;
        System.out.println("Proszę podać liczbę");
        a = scanner.nextInt();
        return a;
    }

    public static void main(String[] args) {
        int a, b, c, suma;
        a = podajLiczbe();
        b = podajLiczbe();
        c = podajLiczbe();
        suma = a + b + c;

        System.out.println("Suma podanych liczb wynosi "+suma);
    }

}
