package observableObserver.thermometer;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class Main {

    public static void main(String[] args) {
        Thermometer thermometer = new Thermometer();
        ConsoleObserver consoleObserver = new ConsoleObserver();
        thermometer.addObserver(consoleObserver);
        thermometer.setGrade(5);
        thermometer.setGrade(6);
        thermometer.setGrade(7);
    }
}
