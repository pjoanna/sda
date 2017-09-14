import java.util.List;

/**
 * Created by amen on 9/13/17.
 */
public class TrainSchedule {
    private List<TrainScheduleRecord> schedule;

    public TrainSchedule(List<TrainScheduleRecord> schedule) {
        this.schedule = schedule;
    }

    public List<TrainScheduleRecord> getSchedule() {
        return schedule;
    }
}
