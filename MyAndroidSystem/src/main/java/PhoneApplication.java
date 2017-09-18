import java.util.List;

/**
 * Created by RENT on 2017-09-16.
 */
public class PhoneApplication extends Application implements CallListener{
 //   private List<> callRegistry;

    @Override
    public void callStarted(int call_id) {
        System.out.println("Phone application startuje!");
    }

    @Override
    public void callEnded(int call_id) {
        System.out.println("Phone application kończy pracę!");
    }
}
