import java.util.List;

/**
 * Created by RENT on 2017-09-16.
 */
public class PatientStateChangedEvent implements Event{
    private int room_id;
    private PatientState patientState;

    public PatientStateChangedEvent(int room_id, PatientState patientState) {
        this.room_id = room_id;
        this.patientState = patientState;
    }

    @Override
    public void run() {
        List<RoomPatientListener> list = EventDispatcher.getInstance().getAllObjectsImplementingInterface(RoomPatientListener.class);

        for (RoomPatientListener roomPatientListener : list) {
            roomPatientListener.patientStateChanged(room_id, patientState);
        }

    }
}
