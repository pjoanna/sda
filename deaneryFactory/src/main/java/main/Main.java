package main;

import applications.Application;
import applications.ApplicationFactory;

import java.util.Scanner;

/**
 * Created by RENT on 2017-08-09.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Application app = ApplicationFactory.createConditionalStayApplication(scanner);



    }

}
