package observableObserver.thermometer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class Thermometer {
    private List<TemparatureObserver> obsevators = new ArrayList<>();

    public void addObserver(TemparatureObserver observer) {
        obsevators.add(observer);
    }

    public void setGrade(int grade) {
        for (TemparatureObserver obsevator : obsevators) {
            obsevator.updateTemperature(grade);
        }
    }
}
