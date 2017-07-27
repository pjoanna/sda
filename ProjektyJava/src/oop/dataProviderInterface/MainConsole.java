package oop.dataProviderInterface;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-15.
 */
public class MainConsole {
    public static void main(String[] args) {
        DataProvider provider = new ConsoleDataProvider();

        Scanner scanner = new Scanner(System.in);
        String choise;
        menu();
        choise = scanner.next();

        while (!choise.equals("wyjście")) {
            switch (choise) {
                case "imię":
                    provider.nextString("imię");
                    break;
                case "nazwisko":
                    provider.nextString("nazwisko");
                    break;
                case "wiek":
                    provider.nextInt("wiek");
                    break;
                case "wyjście":
                    break;
                default:
                    System.out.println("Ups! Literówka. Wpisz jeszcze raz");
                    break;
            }
            menu();
            choise = scanner.next();
        }
    }

    public static void menu() {
        System.out.println("Wpisz co wybierasz");
        System.out.println("imię");
        System.out.println("nazwisko");
        System.out.println("wiek");
        System.out.println("wyjście");
    }

}
