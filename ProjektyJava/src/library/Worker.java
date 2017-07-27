package library;

import java.util.Calendar;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by RENT on 2017-07-18.
 */
public class Worker extends Person {
    private Schedule schedule;

    public Worker(String name, String surname, Schedule schedule) {
        super(name, surname);
        this.schedule = schedule;
    }
}
