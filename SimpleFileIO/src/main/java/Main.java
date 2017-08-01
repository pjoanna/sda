import java.io.*;

/**
 * Created by RENT on 2017-08-01.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Zaczynamy");

        File ourFile = new File("test.txt");
        if (ourFile.exists()){
            System.out.println("Plik istnieje");
        }else {
            System.out.println("Plik nie istnieje");
        }


            try(FileOutputStream stream = new FileOutputStream(ourFile)) {
                PrintWriter writer = new PrintWriter(stream);
             //   stream.write(); - tego unikamy - pisanie na bajtach :P
                writer.println("plik");
                writer.close();

            } catch (IOException e) {
                System.out.println("Exception: " + e.getMessage());
            }







        //isDirecotory() - jest katalogiem/folderem,  isFile() - jest plikiem
        //mkdir - tworzy katalog
        //
    }
}
