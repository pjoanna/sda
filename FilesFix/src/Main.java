import java.io.*;
import java.util.Scanner;

/**
 * Created by amen on 8/1/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Zaczynamy.");

        File file = new File("test.txt");
        checkIfFileExists(file);
        Scanner scanner = new Scanner(System.in);

        tryToFillFile(file, scanner);
    }

    private static void tryToFillFile(File file, Scanner scanner) {
        try (FileOutputStream stream = new FileOutputStream(file); PrintWriter writer = new PrintWriter(stream)) {
            writeFormsToFile(scanner, writer);
        } catch (IOException e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }

    private static void writeFormsToFile(Scanner scanner, PrintWriter writer) {
        FormManager filler = new FormManager(scanner);
        do {
            Form form = filler.createAndFillForm();
            writer.println(form);
        } while (ask(scanner, "Czy chcesz wypełnić kolejną ankietę? (tak/nie):").equals("tak"));
    }


    private static String ask(Scanner sc, String text) {
        System.out.println(text);
        return sc.nextLine();
    }

    private static void checkIfFileExists(File file) {
        if (file.exists()) {
            System.out.println("Plik istnieje.");//
        } else {
            System.out.println("Plik nie istnieje.");
        }
    }
}
