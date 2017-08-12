import java.util.Scanner;

/**
 * Created by RENT on 2017-08-12.
 */
public class Main {
    public static void main(String[] args) {
        SmsStation station = new SmsStation();

        System.out.println("wybierz polecenie");
        System.out.println("sendMessage numer_tel treść_wiadomości");
        System.out.println("addPhone nr_tel");
        System.out.println("quit");

        Scanner scanner = new Scanner(System.in);
        String commandLine = scanner.nextLine();
        String[] splitedLine = commandLine.split(" ");
        String command = splitedLine[0];

        while(!command.equals("quit")){
            switch (command) {
                case "sendMessage":
                    String number1 = splitedLine[1];
                    String text1 = splitedLine[2];
                    for (Phone phone : station.getPhoneList()) {
                        if (phone.getNumber().equals(number1)) {
                            station.sendSMS(number1, text1);
                            System.out.println("Wysłano wiadomość");
                        } else {
                            System.out.println("W bazie nie ma podanego numeru");
                        }
                    }
                    break;
                case "addPhone":
                    String number2 = splitedLine[1];
                    for (Phone phone : station.getPhoneList()) {
                        if (phone.getNumber().contains(number2)) {
                            System.out.println("Podany numer istnieje już w bazie");
                        } else {
                            station.addPhone(new Phone(number2));
                            System.out.println("Dodano nowy numer do bazy");
                        }
                    }
                    break;
                default:
                    break;


            }
            System.out.println("Podaj następne polecenie");
            commandLine = scanner.nextLine();
            splitedLine = commandLine.split(" ");
            command = splitedLine[0];
        }


    }


}
