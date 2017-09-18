/**
 * Created by RENT on 2017-09-16.
 */
public class CallRecorderApplication extends Application implements CallListener {
    @Override
    public void callStarted(int call_id) {
        System.out.println("call recorder application startuje!");
    }

    @Override
    public void callEnded(int call_id) {
        System.out.println("call recorder application kończy pracę!");
    }
}
