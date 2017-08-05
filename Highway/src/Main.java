import java.util.Scanner;

/**
 * Created by RENT on 2017-08-05.
 */
public class Main {
    public static void main(String[] args) {
        Highway highway = new Highway();
        Scanner scanner = new Scanner(System.in);
        String command;
        boolean isActive = true;

        highway.vehicleEntry("AAA1234", CarType.CAR);
        highway.vehicleEntry("BBB1234", CarType.MOTORCYCLE);
        highway.vehicleEntry("CCC1234", CarType.TRACK);
        highway.vehicleEntry("DDD1234", CarType.CAR);

        while (isActive) {
            System.out.println("Wybierz: ");
            System.out.println("wjazd NR_REJESTRACYJNY TYP");
            System.out.println("wyjazd NR_REJESTRACYJNY");
            System.out.println("sprawdź NR_REJESTRACYJNY");
            System.out.println("quit");

            command = scanner.nextLine();
            System.out.println("Podaj numer rejestracyjny pojazdu");
            String registrationNumber = scanner.next();
            switch (command) {
                case "wjazd NR_REJESTRACYJNY TYP":
                    System.out.println("Podaj typ (TRUCK, CAR, MOTORCYCLE)");
                    String carTypeName = scanner.next().toUpperCase();
                    highway.vehicleEntry(registrationNumber, CarType.valueOf(carTypeName));
                    break;
                case "wyjazd NR_REJESTRACYJNY":
                    highway.vehicleLeave(registrationNumber);
                    break;
                case "sprawdź NR_REJESTRACYJNY":
                    highway.searchVehicle(registrationNumber);
                    break;
                case "quit":
                    isActive = false;
                default:
                    System.out.println("Pojazd o podanym numerze rejestracyjnym nie istnieje ...");
                    break;
            }
        }

    }
}
