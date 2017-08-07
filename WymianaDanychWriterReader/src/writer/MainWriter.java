package writer;

import java.io.*;
import java.util.Scanner;

public class MainWriter {

    public static final String QUIT = "quit";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        try {
            PrintWriter writer = new PrintWriter("plik.txt");

            while (!command.equals(QUIT)) {
                System.out.println("Podaj tekst do zapisania w pliku");
                String line = scanner.nextLine();

                String[] split = line.split(" ");
                if (split[0].equals("SET_FILE")) {
                    writer.close(); // trzeba zamknąć writer żeby zapisał się plik??
                    System.out.println(line);
                    String fileName = split[1] + ".txt";
                    writer = new PrintWriter(fileName);
                    System.out.println("Utworzono plik: " + fileName);
                } else {
                    writer.println(line);
                    writer.flush();
                    System.out.println("Przesłano: " + line);
                }

                System.out.println("Czy kontynuować? (quit zamyka)");
                command = scanner.nextLine();
            }
            writer.println(QUIT);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}

