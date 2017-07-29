package cities.app;

import java.util.Scanner;

/**
 * Created by RENT on 2017-07-29.
 */
public class App {
    private boolean running;
    public void startApp(){

        CityRepository cityRepository = new CityRepository();
        UserInterface userInterface = new UserInterface(UserInterface.polishTranslation());
        CommandExecutor executor = new CommandExecutor(userInterface, cityRepository, this);
        CommandParser parser = new CommandParser(executor);

        running = true;
        Scanner scanner = new Scanner(System.in);
        while (running) {
            userInterface.showMessage(UserInterface.Message.NEXT_COMMAND);
            String command = scanner.nextLine();
            parser.parse(command);
        }
    }

    public void closeApp(){
        running = false;

    }

    public static void main(String[] args) {
        App app = new App();
        app.startApp();
    }
}
