package observableObserver.thermometer;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class ConsoleObserver implements TemparatureObserver {

    @Override
    public void updateTemperature(int grades) {
        System.out.println("Temperatura : " + grades);
    }
}
