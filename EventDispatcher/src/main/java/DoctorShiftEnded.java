import java.util.List;

/**
 * Created by RENT on 2017-09-16.
 */
public class DoctorShiftEnded implements Event {
    private Doctor doc;

    public DoctorShiftEnded(Doctor doc) {
        this.doc = doc;
    }

    @Override
    public void run() {
        List<DoctorShiftListener> list = EventDispatcher.getInstance().getAllObjectsImplementingInterface(DoctorShiftListener.class);
        for (DoctorShiftListener listener : list) {
            listener.doctorShiftEnded(doc);
        }
    }
}
