package reader;

import java.io.*;
import java.util.Scanner;

/**
 * Created by RENT on 2017-08-05.
 */
public class MainReader {
    public static void main(String[] args) {
        File file = new File("plik.txt");
        long lastModifiedTime = file.lastModified();
        long lastLenght = file.length();
        Scanner scanner = new Scanner(System.in);

        boolean isLoopRunning = true;
        try (BufferedReader reader = new BufferedReader(new FileReader("plik.txt"))) {
            String lineFromFile = "";

            while (isLoopRunning) {
                Thread.sleep(1000);

                if ((file.lastModified() - lastModifiedTime) != 0 || lastLenght != (file.length())) {
                    lastModifiedTime = file.lastModified();
                    lastLenght = file.length();
                    while (true) {
                        lineFromFile = reader.readLine();
                        if (lineFromFile == null) {
                            break;
                        }
                        System.out.println(lineFromFile);
                        if (lineFromFile.equals("quit")) {
                            isLoopRunning = false;
                        }
                        System.out.println("Odebrano linię: " + lineFromFile);
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e0) {

        } catch (IOException e1) {
            e1.getMessage();
        } catch (InterruptedException e) {
            e.getMessage();
        }

    }
}
