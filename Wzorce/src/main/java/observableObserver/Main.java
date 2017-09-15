package observableObserver;

import java.util.Scanner;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class Main {

    public static void main(String[] args) {
        SmsStation station = new SmsStation();
        station.addPhonesOnStart();
        menuOnStart();
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(station, scanner);
        userInterface.handleCommands();
    }

    private static void menuOnStart() {
        System.out.println("wybierz polecenie");
        System.out.println("sendMessage numer_tel treść_wiadomości");
        System.out.println("addPhone nr_tel");
        System.out.println("quit");
    }
}
