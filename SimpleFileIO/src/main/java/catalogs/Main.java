package main.java.catalogs;

import java.io.File;
import java.util.Scanner;

/**
 * Created by RENT on 2017-08-01.
 */
public class Main {


    public static void main(String[] args) {
        File file;
        Scanner scanner = new Scanner(System.in);
        String line = "";
        String path = "";
        System.out.println("Podaj nazwę pliku / katalogu");

        do {
            path = scanner.nextLine();
            file = new File(path);
         //   if (file.isFile()) {
            System.out.println(file.exists());
                System.out.println("Ścieżka relatywna: " + file.getPath());
                System.out.println("Ścieżka absolutna: " + file.getAbsolutePath());
                System.out.println("Wielkość pliku/katalogu: " + file.getTotalSpace());
                System.out.println("Data ostatniej modyfikacji: " + file.lastModified());
                System.out.println("Czy plik jest ukryty: " + file.isHidden());
                System.out.println("Prawo dostępu do odczytu: " + file.canRead());
                System.out.println("Prawo dostępu do zapisu: " + file.canWrite());
                System.out.println("Prawo dostępu do wykonywania: " + file.canExecute());
        //    } else if (file.isDirectory()) {
//                for (File file1 : file.listFiles()) {
//                    System.out.println(file1.getName() + " " + file1.getTotalSpace() + " " + file1.lastModified());
//                }
       //     }
            System.out.println("Podaj kolejną nazwę ");
            line = scanner.nextLine();
        } while (line.equals("quit"));
    }
}
