import java.io.*;
import java.util.Scanner;

/**
 * Created by RENT on 2017-08-03.
 */
public class MainWrite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("plik.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            PrintWriter writer = new PrintWriter(fileOutputStream);
            do {
                System.out.println("Podaj tekst do zapisania w pliku");
                String line = scanner.nextLine();
                writer.println(line);

            } while (true);

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
