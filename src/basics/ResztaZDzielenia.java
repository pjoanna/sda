package basics;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-08.
 */
public class ResztaZDzielenia {
    public static int podajLiczbe(){
        int liczba;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Proszę podać liczbę");
        liczba = scanner.nextInt();
        return liczba;
    }

    public static void main(String[] args) {
        int liczba1, liczba2, reszta;
        liczba1 = podajLiczbe();
        liczba2 = podajLiczbe();
        reszta = liczba1%liczba2;

        System.out.println("Reszta z dzielenia tych liczb wynosi: "+reszta);

        if (reszta ==0){
            System.out.println("Te liczby są przez siebie podzielne");
        }else {
            System.out.println("Te liczby są niepodzielne");
        }


    }
}
