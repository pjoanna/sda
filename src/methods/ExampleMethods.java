package methods;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-10.
 */
public class ExampleMethods {
    public static void main(String[] args) {
        printHelloWorld();
        //  printRect(3,4);
        //  printTriangle(4);
        //   printEmptyRect(4,5);
        System.out.println(minOfTwoCounts(3, 5));
        System.out.println(minOfTwoCounts(-1, 8));
        System.out.println(minOfTwoCounts(8, -2));

        double[] array1 = {1,2,3,4,1,23,4,1,2,3,4,1,2,3,4};
        howManyNumbersInArray(array1);


    }

    public static void printHelloWorld() {
        System.out.println("Hello World!");
    }

    public static void printHelloWorld(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " Hello World!");
        }
    }

    public static void sumTwoCounts(int a, int b) {
        System.out.println(a + b);
    }

    public static int multiplyTwoCounts(int a, int b) {
        System.out.println(a * b);
        return a * b;
    }

    public static double minOfTwoCounts(double count1, double count2) {
        double result = count1;
        if (count2 < result) {
            result = count2;
        }
        return result;
    }

    public static int minOfThreeCounts(int count1, int count2, int count3) {
        int result = count1;
        if (count2 < result) {
            result = count2;
        }
        if (count3 < result) {
            result = count3;
        }
        System.out.println(result);
        return result;
    }
    public static double minOfThreeCounts2(double count1, double count2, double count3){
        double result = minOfTwoCounts(minOfTwoCounts(count1,count2),count3);
        return result;
    }

    public static void printRect(int a, int b) {
        for (int i = 0; i < a; i++) {
            printLine(b);
        }
    }

    private static void printLine(int b) {
        for (int j = 0; j < b; j++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void printTriangle(int a) {
        String rysuj = "";
        for (int i = 0; i < a; i++) {
            rysuj += "*";
            System.out.println(rysuj);

        }

    }

    public static void printEmptyRect(int a, int b) {
        for (int i = 0; i < a; i++) {
            printLine(b);

        }
    }


    public static double smallestNumber(double[] tab) {
        double smallest = tab[0];
        for (int i = 0; i < tab.length; i++) {
            smallest = minOfTwoCounts(smallest,tab[i]);
        }
        return smallest;
    }

    public static int howManyNumbersInArray(double[] tab){
        int result = -1;
        double myCount;
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj jakąś liczbę");
        myCount = scanner.nextInt();
        for (int i = 1; i < tab.length; i++) { //od 1 bo nie ma sensu porównać pierwszegoelementu z samym sobą :P
            if(tab[i] == myCount){
                counter++;
            }
        }
        result = counter;
        System.out.println(result);
        return result;
    }

}
