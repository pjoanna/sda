package my.arrays;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-08.
 */
public class Array3 {
    public static Scanner scanner = new Scanner(System.in);

    public static int getArrayElement(){
        System.out.println("Podaj kolejny element tablicy");
        int element = scanner.nextInt();
        return element;
    }

    public static void main(String[] args) {
        System.out.println("Podaj rozmiar tablicy");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = getArrayElement();
        }
//        for(int number : numbers){
//            number = getArrayElement(); // ta funkcja nie nadaje się do edycji tablic
//        }

        for(int number : numbers){
            System.out.println(number);
        }
    }
}
