import java.util.Scanner;

/**
 * Created by RENT on 2017-09-16.
 */
public class Main {

    public static void main(String[] args) {
        AndroidSystem manager = new AndroidSystem();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String command = line.split(" ")[0];
            int call_id = Integer.parseInt(line.split(" ")[1]);
            if (command.equalsIgnoreCase("start")) {
                manager.startCall(call_id);
            } else if (command.equalsIgnoreCase("stop")) {
                manager.endCall(call_id);
            }
        }
    }

}
