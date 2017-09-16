import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;

/**
 * Created by RENT on 2017-09-15.
 */
public class Doctor extends AbstractUnit implements RoomPatientListener, Runnable {
    private boolean isFree;
    private List<Room> rooms;
    private List<Room> roomsPriorities;
    private String name;
    private int shiftlength;

    public Doctor(boolean isFree, List<Room> rooms, String name, int shiftlength) {
        this.isFree = isFree;
        this.rooms = rooms;
        this.shiftlength = shiftlength;
        roomsPriorities = new ArrayList<>();
        this.name = name;
        Executors.newSingleThreadExecutor().submit(this);
    }


    @Override
    public void patientStateChanged(int room, PatientState state) {

        for (Room room1 : rooms) {
           if (room1.getRoom_id() == room && room1.getHealthPoints() < 20){
               roomsPriorities.add(room1);
           }
        }
        System.out.println("Pacjent z pokoju " + room + " jest w stanie " + state);
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.name);
        while (shiftlength-- > 0) {
            for (Room r : roomsPriorities) {
                handleRoom(r);
            }
            for (Room r : rooms) {
                handleRoom(r);
                if (!roomsPriorities.isEmpty()) {
                    break;
                }
            }
        }
    }

    private void handleRoom(Room r) {
        r.setHealthPoints(r.getHealthPoints() + 10);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
}
