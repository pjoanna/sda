import java.util.Observable;

import java.util.Observer;

/**
 * Created by RENT on 2017-09-18.
 */
public class Watcher implements Observer {

    public void update(Observable o, Object arg) {
        if (arg instanceof Program){
            Program program = (Program) arg;
            program.watch();
        }
    }
}
