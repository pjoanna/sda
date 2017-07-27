package loop;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-08.
 */
public class HelloWorldX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int helloWorldCount;
        System.out.println("Podaj, ile razy wyświetlić Hello World");
        helloWorldCount = scanner.nextInt();

        for (int i = 0; i < helloWorldCount; i++) {
            System.out.println("Hello World2!");

        }

        while(helloWorldCount>0){
            System.out.println("Hello World1!");
            helloWorldCount--;
        }
    }

}
