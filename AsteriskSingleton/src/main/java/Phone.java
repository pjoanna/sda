/**
 * Created by RENT on 2017-08-10.
 */
public class Phone {
    public Phone() {
    }

    public void call() {
        AsteriskSingleton.getInstance().call();
    }
}
