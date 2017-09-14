import java.util.Scanner;

/**
 * Created by amen on 9/13/17.
 */
public class Main {

    public static void main(String[] args) {
        Headquarter h = new Headquarter();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("start g")) {
                System.out.println("Startuje pociąg z Gdańska");
                h.dispatchTrainFromGdansk();
            } else if (line.startsWith("start w")) {
                System.out.println("Startuje pociąg z Wejherowa");
                h.dispatchTrainFromWejherowo();
            } else if (line.startsWith("print ")) {
                String stationId = line.replace("print ", "");
                int station_id = Integer.parseInt(stationId);

                h.printTrainInfoOf(station_id);
            }
        }
    }
}