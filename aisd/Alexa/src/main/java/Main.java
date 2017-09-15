import java.util.Scanner;

/**
 * Created by RENT on 2017-09-14.
 */
public class Main {
    public static void main(String[] args) {
        AlexaDevice device = new AlexaDevice();
        AlexaServer server = AlexaServer.getInstance();

        device.addObserver(server);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("register")) { // podłącz internet
                if (device.countObservers() == 0) {
                    device.addObserver(server);
                }
            } else if (line.equalsIgnoreCase("unregister")) { // rozłącz internet
                device.deleteObserver(server);
            } else {
                device.sendRequest(line); // wykonaj zapytanie do alexy
            }
        }
    }
}
