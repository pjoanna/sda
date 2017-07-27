package middle;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-11.
 */
public class LetterCounterInArray {
    public static void main(String[] args) {
        String text = "Jakis losowy tekst";
        char myLetter;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj literkę");
        myLetter = scanner.next().charAt(0);   ////ważne do zapamiętania - pobieranie jednego znak, tutaj 1  z danego stringa
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == myLetter){
                counter++;
            }
        }
        System.out.println(counter+" wystąpień litery "+myLetter);
    }

}
