package abstractfactory.main;

import abstractfactory.applications.Application;
import abstractfactory.applications.AbsApplicationFactory;
import abstractfactory.applications.ConsoleApplicationFactory;

import java.util.Scanner;

/**
 * Created by RENT on 2017-08-09.
 */
public class Main {
    public static void main(String[] args) {


        startApp(new ConsoleApplicationFactory(new Scanner(System.in)));
    }

    private static void startApp(AbsApplicationFactory factory) {
        Application app = factory.createConditionalStayApplication();

    }

}
