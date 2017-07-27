package collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pjoanna on 2017-07-20.
 */
public class FiveNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj pięć liczb. Oddzielaj je Enterem");
        double number1 = scanner.nextDouble();
        double number2 = scanner.nextDouble();
        double number3 = scanner.nextDouble();
        double number4 = scanner.nextDouble();
        double number5 = scanner.nextDouble();

        List<Double> list = new ArrayList<>();

        list.add(number1);
        list.add(number2);
        list.add(number3);
        list.add(number4);
        list.add(number5);

        int counter = 0;
        for (Double number : list) {
            counter++;
            System.out.println("Liczba numer "+ counter +" wynosi "+number);
        }


    }

}
