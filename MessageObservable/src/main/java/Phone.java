import java.util.Observable;
import java.util.Observer;

/**
 * Created by RENT on 2017-08-10.
 */
public class Phone implements Observer {
    private String number;

    public Phone(String number) {
        this.number = number;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Message){

        }
    }
}
