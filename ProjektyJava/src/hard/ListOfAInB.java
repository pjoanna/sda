package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by RENT on 2017-07-12.
 */
public class ListOfAInB {
    public static void main(String[] args) {
        int number1 = getNumber();
        int number2 = getNumber();
        int counter = 1;
        List<Integer> numbers = new ArrayList<Integer>();

        while(counter*number1<number2){
            int myNumber = counter*number1;
            numbers.add(myNumber);
            counter++;
        }
        for (int number : numbers){
            System.out.print(number+"  ");
        }
    }

    public static int getNumber(){
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Proszę podać liczbę: ");
        number = scanner.nextInt();
        return number;
    }
}
