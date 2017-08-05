package writer;

/**
 * Created by RENT on 2017-08-05.
 */
import java.io.*;
import java.util.Scanner;

/**
 * Created by RENT on 2017-08-03.
 */
public class MainWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("plik.txt");
        String command = "";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            PrintWriter writer = new PrintWriter(fileOutputStream);

            while (!command.equals("quit")) {
                System.out.println("Podaj tekst do zapisania w pliku");
                String line = scanner.nextLine();

                if (line.split(" ")[0].equals("SET_FILE")) {
                    System.out.println(line);
                    String fileName = line.split(" ")[1] + ".txt";
                    File newFile = new File(fileName);
                    file = newFile;
                    fileOutputStream = new FileOutputStream(file);
                    writer.close(); // trzeba zamknąć writer żeby zapisał się plik
                    writer = new PrintWriter(fileOutputStream);
                    System.out.println("Utworzono plik: " + file.getName());

                } else {
                    writer.println(line);
                    System.out.println("Przesłano: " + line);
                }

                System.out.println("Czy kontynuować? (quit zamyka)");
                command = scanner.nextLine();
            }

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}

