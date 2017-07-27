package middle;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-10.
 */
public class CounterArray {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,1,2,3,2,4,2,1,2,3};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj jakąś liczbę (proponowany zakres: 1-5)");
        int count = scanner.nextInt();
        int licznik = 0;
        for (int number : numbers) {
            if (count == number){
                licznik++;
            }
        }
        System.out.println(licznik);
    }
}
