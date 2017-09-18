import javax.management.Notification;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by RENT on 2017-09-16.
 */
public class AndroidSystem implements CallListener{
    private Integer ongoingCall = null;
    private List<Integer> ongoingCalls;
    private List<Notification> notifications;

    public AndroidSystem() {
        EventDispatcher.getInstance().registerObject(this);
        this.ongoingCalls = new LinkedList<>();
        this.notifications = new LinkedList<>();
        new CallRecorderApplication();
        new PhoneApplication();
    }

    @Override
    public void callStarted(int call_id) {
        ongoingCall = call_id;
        System.out.println("System Android startuje!");
    }

    @Override
    public void callEnded(int call_id) {
        ongoingCall = null;
        System.out.println("System Android kończy pracę!");

    }
    public void startCall(int call_id){
        if (ongoingCall == null) {
            EventDispatcher.getInstance().dispatch(new CallStartedEvent(call_id));
        }
    }

    public void endCall(int call_id){
        if (ongoingCall == call_id) {
            System.out.println("Koncze polaczenie o id: " + call_id);
            EventDispatcher.getInstance().dispatch(new CallEndedEvent(call_id));
        }else{
            System.out.println("Nie mogę zakończyć połączenia które nie zostało rozpoczęte.");
        }
    }
}
