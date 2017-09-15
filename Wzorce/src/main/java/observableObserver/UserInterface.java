package observableObserver;

import java.util.Scanner;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class UserInterface {
    private final SmsStation station;
    private final Scanner scanner;

    public UserInterface(SmsStation station, Scanner scanner) {
        this.station = station;
        this.scanner = scanner;
    }

    public void handleCommands() {
        String command;
        do {
            String commandLine = scanner.nextLine();
            String[] splitedLine = commandLine.split(" ");
            command = splitedLine[0];
            switch (command) {
                case "sendMessage":
                    sendMessage(splitedLine);
                    break;
                case "addPhone":
                    addPhoneToStationDatabase(splitedLine[1]);
                    break;
                default:
                    break;
            }
            System.out.println("Podaj następne polecenie");
        } while (!command.equals("quit"));
    }

    public void addPhoneToStationDatabase(String s) {
        String number2 = s;
        Phone newNumber2 = new Phone(number2);
        if (station.getPhoneList().contains(newNumber2)) {
            System.out.println("Podany numer istnieje już w bazie");
        } else {
            station.addPhone(newNumber2);
            System.out.println("Dodano nowy numer do bazy");
        }
    }
    public void sendMessage(String[] splitedLine) {
        String number1 = splitedLine[1];
        String text1 = splitedLine[2];
        Phone newNumber1 = new Phone(number1);
        if (station.getPhoneList().contains(newNumber1)) {
            station.sendSMS(number1, text1);
            System.out.println("Wysłano wiadomość");
        } else {
            System.out.println("W bazie nie ma podanego numeru");
        }
    }
}
