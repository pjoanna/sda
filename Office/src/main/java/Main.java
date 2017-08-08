import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Created by RENT on 2017-08-08.
 */
public class Main {
    public static void main(String[] args) {
        Department department = new Department();
        Scanner scanner = new Scanner(System.in);
        System.out.println("dodaj_biuro");
        System.out.println("obsluga {PESEL} {REGISTER / UNREGISTER / CHECK_STATUS} {0,1,...}");
        System.out.println("quit");

        Office officeA = new Office();
        Office officeB = new Office();
        department.addOffice(officeA);
        department.addOffice(officeB);
        String command = "";

        while (!command.equals("quit")) {
            System.out.println("Wybierz jedną opcję ");
            String[] words = scanner.nextLine().split(" ");
            command = words[0];
            switch (command) {
                case "dodaj_biuro":
                    department.addOffice(new Office());
                    break;
                case "obsluga":
                    int size = department.getOfficeList().size();
                    System.out.println("rozmiar listy biur wynosi "+size);
                    Long pesel = Long.parseLong(words[1]);
                    pesel = 1L;
                    Business business = Business.valueOf(words[2]);
                    Client client = new Client(pesel, business);
                    int room = Integer.parseInt(words[3]);
                    department.getOffice(room).handle(client);
                    break;
                default:
                    break;
            }

        }


    }

}
