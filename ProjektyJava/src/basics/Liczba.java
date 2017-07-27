package basics;

import java.util.Scanner;


public class Liczba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Proszę podać 1 liczbę");
        int i0 = scanner.nextInt();
        System.out.println("Proszę podać 2 liczbę");
        int i1 = scanner.nextInt();

        if(i0 < i1 && i0 != i1){
            System.out.println("Liczba "+i1+" jest większa");
        }else if(i0 > i1 && i0 != i1){
            System.out.println("Liczba "+i0+" jest większa");
        }else {
            System.out.println("Podane liczby są równe!");
        }


    }
}
