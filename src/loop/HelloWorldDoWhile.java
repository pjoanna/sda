package loop;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-08.
 */
public class HelloWorldDoWhile {
    public static void wyswietl(){
        System.out.println("Hello World! :)");
    }
    public static int podajLiczbe(){
        Scanner scanner = new Scanner(System.in);
        int i;
        System.out.println("Podaj liczbę");
        i = scanner.nextInt();
        return i;
    }
    public static void main(String[] args) {
        int a = podajLiczbe();
        do {
            wyswietl();
            a = podajLiczbe();
        }while (a>0);
    }
}
