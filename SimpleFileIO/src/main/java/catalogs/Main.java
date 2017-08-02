package main.java.catalogs;

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
        File file;
        Scanner scanner = new Scanner(System.in);
        String line = "";
        String path = "";
        createAndFillFile(scanner);
    }

    private static void createAndFillFile(Scanner scanner) {
        try (FileOutputStream stream = new FileOutputStream("dane o plikach.txt")) {
            PrintWriter writer = new PrintWriter(stream);
            fileSupport(scanner, writer);
            writer.close();

        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private static void fileSupport(Scanner scanner, PrintWriter writer) throws IOException {
        String path;
        File file;
        String line;
        do {
            System.out.println("Podaj nazwę pliku / katalogu");
            path = scanner.nextLine();
            file = getFileName(path);
            writeToFileDataAboutFileOrDirectory(file, writer);
            System.out.println("Czy kontynuować? (quit zamyka)");
            line = scanner.nextLine();
        } while (!line.equals("- quit"));
    }

    private static void writeToFileDataAboutFileOrDirectory(File file, PrintWriter writer) {
        if (file.isFile()) {
            writer.println("Czy plik istnieje: " + file.exists());
            writer.println("Ścieżka relatywna: " + file.getPath());
            writer.println("Ścieżka absolutna: " + file.getAbsolutePath());
            writer.println("Wielkość pliku/katalogu: " + file.getTotalSpace());
            writer.println("Data ostatniej modyfikacji: " + file.lastModified());
            writer.println("Czy plik jest ukryty: " + file.isHidden());
            writer.println("Prawo dostępu do odczytu: " + file.canRead());
            writer.println("Prawo dostępu do zapisu: " + file.canWrite());
            writer.println("Prawo dostępu do wykonywania: " + file.canExecute());
        } else if (file.isDirectory()) {
            for (File file1 : file.listFiles()) {
                writer.println(file1.getName() + " " + file1.length() + " " + file1.lastModified());
            }
        }
    }

    private static File getFileName(String path) throws IOException {
        File file;
        String[] words = path.split(" ");
        String command = words[0];
        file = new File(words[1]);
        switch (command) {
            case "delete":
                file.delete();
                System.out.println("Usuwam");
                break;
            case "createFolder":
                file.mkdir();
                System.out.println("tworzę folder");
                break;
            case "createFile":
                file.createNewFile();
                System.out.println("tworzę plik");
                break;
            default:
                System.out.println("cokolwiek");
                break;
        }
        return file;
    }

}
