import java.util.Observable;
import java.util.Observer;

public class Train extends Observable implements Runnable {

    private static int train_counter = 0;
    private int train_id = train_counter++;
    private boolean isCancelled = false;
    private int stationId;
    private boolean direction; //true is increment, false is decrement;
    private TrainSchedule schedule;

    public Train(int stationId, boolean direction, TrainSchedule schedule) {
        this.stationId = stationId;
        this.direction = direction;
        this.schedule = schedule;
    }


    public void run() {
        // każdy pociąg porusza się po linii
        int schedule_counter = 0;

        setChanged();
        notifyObservers();

        // każdy pociąg jeśli zatrzymuje sie na stacji, to czeka na niej dokładnie 1 sek.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (schedule_counter < schedule.getSchedule().size()) {
            TrainScheduleRecord record = schedule.getSchedule().get(schedule_counter);
            try {
                Thread.sleep(record.getTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (direction) {
                stationId++;
            } else {
                stationId--;
            }
            // każdy pociąg informuje headquarters o tym że dojechał na stację, nawet jeśli nie zatrzymuje się na niej (nie czeka 1s.)
            setChanged();
            notifyObservers();

            if (!record.isSkip()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // każdy pociąg może być anulowany
            if (isCancelled) {
                break;

                // powiadomienie stacji że pociąg anulowany
            }
            schedule_counter++;
        }


    }

    public int getStationId() {
        return stationId;
    }

    public void cancelledTrain(){
        isCancelled = true;
    }
}