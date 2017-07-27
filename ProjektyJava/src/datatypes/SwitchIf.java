package datatypes;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-06.
 */
public class SwitchIf {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Proszę podać 1 liczbę");
        int i0 = scanner.nextInt();
        System.out.println("Proszę podać 2 liczbę");
        int i1 = scanner.nextInt();
        System.out.println("Proszę podać instrukcję");
        String instr = scanner.next();

        switch (instr){
            case "+":
                System.out.print("Wynik to: ");
                System.out.println(i0+i1);
                break;
            case "-":
                System.out.print("Wynik to: ");
                System.out.println(i0-i1);
                break;
            case "*":
                System.out.print("Wynik to: ");
                System.out.println(i0*i1);
                break;
            case "/":
                System.out.print("Wynik to: ");
                System.out.println(i0/i1);
                break;
            default:
                System.out.println("Podano nieprawidłową instrukcję");
                break;
        }

    }
}
