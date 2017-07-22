package middle;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-11.
 */
public class MultipleAandB {
    public static void main(String[] args) {
        int number1 = getNumber();
        int number2 = getNumber();
        int counter = 1;

        while(counter*number1<number2){
            System.out.println(counter*number1);
            counter++;
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
