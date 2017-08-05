package reader;

import java.io.*;
import java.util.Scanner;

/**
 * Created by RENT on 2017-08-05.
 */
public class MainReader {
    public static void main(String[] args) {
        File file = new File("plik.txt");
        long startTime = file.lastModified();
        long startLength = file.length();
        Scanner scanner = new Scanner(System.in);

        boolean isLoopRunning = true;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String lineFromFile = "";

            while (isLoopRunning) {
                Thread.sleep(100);

                if (file.lastModified() - startTime != 0 || startLength != (file.length())) {

                    while (!reader.readLine().equals(null)) {
                        lineFromFile = reader.readLine();
                        System.out.println(lineFromFile);
                        if (lineFromFile.equals("quit")) {
                            isLoopRunning = false;
                        }

                        System.out.println("Odebrano linię: " + lineFromFile);
                    }

                }// TODO: jesli czytamy caly plik, to teraz trzeba wypisac tylko NAJNOWSZA linie
                reader.close();
            }
        } catch (FileNotFoundException e0) {

        } catch (IOException e1) {
            e1.getMessage();
        } catch (InterruptedException e) {
            e.getMessage();
        }

    }
}
