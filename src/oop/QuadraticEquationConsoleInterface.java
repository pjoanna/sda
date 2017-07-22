package oop;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-12.
 */

/// poprawić!!
public class QuadraticEquationConsoleInterface {
    private static Scanner in;
    private static QuadraticEquation equation;

    public static void printQuestion(String word){
        System.out.println("Podaj współczynnik" + word);
    }
    public static void startMenu(){
        printQuestion("a");
        double a = in.nextDouble();
        printQuestion("b");
        double b = in.nextDouble();
        printQuestion("c");
        double c = in.nextDouble();
        QuadraticEquation equation = new QuadraticEquation(a,b,c);
    }

    public static void menu(){
        System.out.println("Wybierz, co chcesz zrobić");
        System.out.println("1 oblicz deltę");
        System.out.println("2 oblicz miejsca zerowe");
        System.out.println("3 wpisz inne współczynniki");
        System.out.println("4 wyjdź");
        int choise = in.nextInt();
        switch (choise){
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default: break;
        }

    }

    public static void main(String[] args) {



        menu();

    }
}
