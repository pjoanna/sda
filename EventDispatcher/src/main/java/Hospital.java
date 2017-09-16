import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-09-15.
 */
public class Hospital implements DoctorShiftListener{
    private List<Room> rooms1;
    private List<Room> rooms2;
    private Doctor doctor1;
    private Doctor doctor2;


    public Hospital() {
        rooms1 = new ArrayList<Room>();
        rooms2 = new ArrayList<Room>();
        Room room1 = new Room(1,PatientState.STABLE, 55);
        Room room2 = new Room(2,PatientState.BAD, 25);
        Room room3 = new Room(3,PatientState.GOOD, 82);
        Room room4 = new Room(4,PatientState.STABLE, 75);

        rooms1.add(room1);
        rooms1.add(room2);
        rooms2.add(room3);
        rooms2.add(room4);

        doctor1 = new Doctor(true, rooms1, "doc1", 3);
        doctor2 = new Doctor(true, rooms2, "doc2", 5);

    }

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
    }


    @Override
    public void doctorShiftStarted(Doctor d) {
        System.out.println("Lekarz zaczął pracę : " + d.getName());
    }

    @Override
    public void doctorShiftEnded(Doctor d) {
        System.out.println("Lekarz skończył pracę : " + d.getName());
    }
}
