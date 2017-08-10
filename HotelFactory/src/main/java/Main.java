import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz opcję");
        System.out.println("guest id_goscia register nr_pokoju");
        System.out.println("guest id_goscia unregister nr_pokoju");
        System.out.println("call internal number");
        System.out.println("call external number");
        System.out.println("random");

        String command = scanner.nextLine();

        switch (command) {
            case "register_guest":
                hotel.register();
                break;
            case "unregister_guest":
                hotel.unregister();
                break;
            case "call_internal":
                break;
            case "call_external":
                hotel.externalConnection();
                break;
            case "random":
                break;
            default:
                break;

        }
    }
}
