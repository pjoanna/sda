import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by RENT on 2017-09-15.
 */
public class Room extends AbstractUnit{
    private int room_id;
    private PatientState patientState;
    private Timer timer;
    private int healthPoints;

    public Room(int room_id, PatientState patientState, int healthPoints) {
        super(); // czy super musi tu być? sprawdzić!
        this.room_id = room_id;
        this.patientState = patientState;
        this.healthPoints = healthPoints;
        this.timer = new Timer(String.valueOf(room_id));
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Random random = new Random();
                Room.this.healthPoints -= random.nextInt(20);

                if (Room.this.healthPoints < 10) {
                    Room.this.patientState = PatientState.CRITICAL;
                } else if (Room.this.healthPoints < 30) {
                    Room.this.patientState = PatientState.BAD;
                } else if (Room.this.healthPoints < 80) {
                    Room.this.patientState = PatientState.STABLE;
                } else {
                    Room.this.patientState = PatientState.GOOD;
                }

                EventDispatcher.getInstance().dispatch(new PatientStateChangedEvent(room_id, Room.this.patientState));

            }
        }, 10000, 8000);
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public PatientState getPatientState() {
        return patientState;
    }

    public void setPatientState(PatientState patientState) {
        this.patientState = patientState;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
