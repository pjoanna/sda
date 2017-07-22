package throwables;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-15.
 */
public class DivideABThrow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj a");
        int a = scanner.nextInt();
        System.out.println("podaj b");
        int b = scanner.nextInt();

        try{
            System.out.println(a/b + " i " + a%b + "/" +b);
        }catch (ArithmeticException e){
            System.out.println("Dzielenie przez zero " + e.getMessage());
        }
//
//        if(b != 0){
//        System.out.println(a/b + " i " + a%b + "/" +b);
//        }else {
//            System.out.println("Dzielenie przez zero :||");
//        }
    }
}
