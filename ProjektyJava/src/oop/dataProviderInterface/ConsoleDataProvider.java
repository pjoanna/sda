package oop.dataProviderInterface;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-15.
 */
public class ConsoleDataProvider implements DataProvider{
    Scanner scanner = new Scanner(System.in);
    @Override
    public int nextInt(String name) {
        System.out.println("Podaj "+name);
        int value = scanner.nextInt();
        return value;
    }

    @Override
    public String nextString(String name) {
        System.out.println("Podaj "+name);
        String value = scanner.next();
        return value;
    }
}
