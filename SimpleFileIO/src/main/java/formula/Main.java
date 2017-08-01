package main.java.formula;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by RENT on 2017-08-01.
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("formula.txt");
        Scanner scanner = new Scanner(System.in);

        String command;
        String word;


        String name;
        String surname;
        int age;
        String sex;
        String nameAndSurname;
        int children = -1;
        String location = "-";
        String meal = "-";



        do {
            System.out.println("Podaj imię i nazwisko");
            nameAndSurname = scanner.nextLine();
            String[] data = nameAndSurname.split(" ");
            name = data[0];
            surname = data[1];
            System.out.println("Podaj wiek");
            word = scanner.nextLine();
            age = Integer.parseInt(word);
            System.out.println("Podaj płeć");
            sex = scanner.nextLine();

            if ((sex.equals("kobieta") && age >= 18 && age <= 25) || (sex.equals("mezczyzna") && age >= 25 && age <= 30)) {
                System.out.println("Liczba dzieci");
                word = scanner.nextLine();
                children = Integer.parseInt(word);
                System.out.println("Miejsce zamieszkania");
                location = scanner.nextLine();
                System.out.println("Ulubione danie");
                meal = scanner.nextLine();
            }
            System.out.println("Czy chcesz wypełnić kolejną ankietę? ");
            command = scanner.nextLine();
        } while (command.equals("Tak"));

        writeToFile(file, name, surname, age, sex, children, location, meal);

    }

    private static void writeToFile(File file, String name, String surname, int age, String sex, int children, String location, String meal) {
        try (FileOutputStream stream = new FileOutputStream(file)) {
            PrintWriter writer = new PrintWriter(stream);

            writer.println("Imię: " + name);
            writer.println("Nazwisko: " + surname);
            writer.println("Wiek: " + age);
            writer.println("Płeć: " + sex);
            writer.println("Liczba dzieci: " + children);
            writer.println("Miejsce zamieszkania: " + location);
            writer.println("Ulubione danie: " + meal);

            writer.close();

        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private static void getBasedData() {

    }
}
