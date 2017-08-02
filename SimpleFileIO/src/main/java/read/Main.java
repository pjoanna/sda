package main.java.read;

import java.io.*;
import java.util.Scanner;

/**
 * Created by RENT on 2017-08-02.
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("test1.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){

            // BufferedReader buforuje cały plik
            // gdyby używać Scanner PRZY DUŻYCH PLIKACH program działałby dłużej
            // bo za każdym razem odwoływałby się do pliku

            String lineFromFile = "";
            while (lineFromFile != null){
                lineFromFile = reader.readLine();
                System.out.println(lineFromFile);
            }
        }catch (FileNotFoundException e0){

        }catch (IOException e1){

        }
        // scanner np gdy jest zadany  format - np. tekst oddzielony spacjami
        // i gdy nie czytamy linia po linii

        try{
            Scanner scanner = new Scanner(file);
            String line = "";
//            do{
//                System.out.println(line);
//                line = scanner.nextLine();
//            }while (line != null);

        } catch (FileNotFoundException e) {
        }

        try{
            Scanner scanner = new Scanner(file);
            String line = "";

            while (line != null){
                System.out.println(line);
                line = scanner.nextLine();
            }

        } catch (FileNotFoundException e) {
        }
    }
}
