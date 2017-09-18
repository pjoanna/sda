import java.util.List;

/**
 * Created by RENT on 2017-09-16.
 */
public class CallEndedEvent implements Event{
    private int call_id;

    public CallEndedEvent(int call_id) {
        this.call_id = call_id;
    }

    @Override
    public void run() {
        List<CallListener> list = EventDispatcher.getInstance().getAllObjectsImplementingInterface(CallListener.class);
        for (CallListener listener : list) {
            listener.callEnded(call_id);
        }
    }
}
