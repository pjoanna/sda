import java.util.List;

/**
 * Created by RENT on 2017-09-15.
 */
public class Doctor extends AbstractUnit implements RoomPatientListener{
    private boolean isFree;
    private List<Room> rooms;

    public Doctor(boolean isFree, List<Room> rooms) {
        this.isFree = isFree;
        this.rooms = rooms;
    }

    @Override
    public void patientStateChanged(int room, PatientState state) {

    }
}
