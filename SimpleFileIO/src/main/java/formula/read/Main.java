package main.java.formula.read;

import java.io.*;
import java.util.Scanner;

/**
 * Created by amen on 8/1/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Zaczynamy.");

        File naszPlik = new File("test.txt");
        if (naszPlik.exists()) {
            System.out.println("Plik istnieje.");
        } else {
            System.out.println("Plik nie istnieje.");
        }

        Scanner sc = new Scanner(System.in);

         try (FileOutputStream fos = new FileOutputStream(naszPlik);
             PrintWriter writer = new PrintWriter(fos)) {


            do {
                Form formularz = new Form();
                System.out.println("Podaj imie i nazwisko:");
                formularz.setImie(sc.nextLine());
                Integer wiek = null;
                do {
                    System.out.println("Podaj wiek:");
                    String wiek_string = sc.nextLine();

                    try {
                        wiek = Integer.parseInt(wiek_string);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Nieporawne dane wejsciowe.");
                    }
                } while (wiek == null);
                formularz.setWiek(wiek);
                System.out.println("Podaj plec:");
                formularz.setPlec(sc.nextLine());

                if((formularz.getPlec().toLowerCase().equals("mezczyzna") && wiek >25 && wiek <30)  ||
                        formularz.getPlec().toLowerCase().equals("kobieta") && wiek >18 && wiek <25){
                    System.out.println("Pytanie1:");
                    formularz.setOdp1(sc.nextLine());

                    System.out.println("Pytanie2:");
                    formularz.setOdp2(sc.nextLine());

                    System.out.println("Pytanie3:");
                    formularz.setOdp3(sc.nextLine());
                }else {
                    System.out.println("Nie spełniasz kryteriów wiekowych ankiety, dziękujemy!");
                }
                writer.println(formularz);
                System.out.println("Czy chcesz wypełnić kolejną ankietę? (tak/nie)");
            } while (sc.nextLine().equals("tak"));

        } catch (IOException fnfe) {
            System.out.println("Exception : " + fnfe.getMessage());
        }
    }
}