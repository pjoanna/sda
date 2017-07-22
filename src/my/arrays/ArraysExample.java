package my.arrays;

import sun.text.bidi.BidiBase;

/**
 * Created by RENT on 2017-07-08.
 */
public class ArraysExample {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        System.out.println(numbers[5]);

        int[] ones = {1,1,1,1};
        int[] ones1 = {1,2,3,4};
        System.out.println(ones1[0]);
        System.out.println(ones1[3]);

        String[] words = {"table","chair"};
        System.out.println(words[0]);

        int[][] arrays = {numbers, ones, {5}, null};
        System.out.println(arrays[2][0]); // tablica z jedną piątką
        System.out.println(arrays[2]); // dziwactwo drukuje; wynikiem jest adres tablicy
        System.out.println(arrays[3]); // null po prostu bo pusta tablica
  //      System.out.println(arrays[3][0]); /// błąd - nie ma tablicy nulli

        int[][] arrays2 = new int[4][];  // wypełnione nullami
        System.out.println(arrays2[2]);  // null

        String[] strings = new String[6]; // wypełnione nullami
        System.out.println(strings[2]);     // null, bo tablica pusta
        int[][] number2 = new int[3][4];  // wypełnione zerami
        System.out.println(number2[0]);  // wynikiem jest adres tablicy
        System.out.println(number2[0][0]); // wyświetla zero
     //   System.out.println(number2[3][0]); // błąd

        char[] chars = new char[4];
        chars[0] = 'a';
        chars[1] = 'b';
        chars[2] = 'c';
        System.out.println(chars[0]); // literka
        System.out.println(chars[3]); // 0 w kodzie ascii odpowiada znakowi który się wyswietli

        int[] data = new int[3];
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
        for(int number : data){ // dla każdego elementu z tablicy data wypisz ten element
            System.out.println(number);
        }
    }
}
