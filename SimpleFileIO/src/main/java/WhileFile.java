package main.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by RENT on 2017-08-01.
 */
public class WhileFile {
    public static void main(String[] args) {
        File file = new File("test1.txt");
        Scanner scanner = new Scanner(System.in);
        String line = "";


        try (FileOutputStream stream = new FileOutputStream(file)) {
            PrintWriter writer = new PrintWriter(stream);

            do {
                System.out.println("napisz coś");
                line = scanner.nextLine();
                if (!(line.equals("quit"))) {
                    writer.println(line);
                }
            }
            while (!(line.equals("quit")));

            writer.close();

        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }


    }
}
