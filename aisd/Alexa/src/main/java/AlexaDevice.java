import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by RENT on 2017-09-14.
 */
public class AlexaDevice extends Observable {
    private static int id = 0;
    private ExecutorService threads = Executors.newSingleThreadExecutor();

    public AlexaDevice() {
        id++;
    }

    public void sendRequest(String requestString) {
        Request request = new Request(requestString, this);
        setChanged();
        notifyObservers(request);

    }

    public void invoke(AbstractSkill abstractSkill) {
        threads.submit(abstractSkill);
    }
}
