import java.util.Scanner;

/**
 * Created by RENT on 2017-08-05.
 */
public class Main {
    public static void main(String[] args) {
        Magazine magazine = new Magazine();

        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Wybierz: ");
        command = scanner.nextLine();
        switch (command) {
            case "dodaj NAZWA_PRODUKTU CENA TYP Z_JAKIEJ_POLKI":
                break;
            case "wylistuj_typ TYP":
                break;
            case "wylistuj_polka Z_JAKIEJ_POLKI":
                break;
            default:
                break;
        }
    }
}
