import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by RENT on 2017-08-10.
 */
public class McDonald extends Observable {

    public void handleOrder(String order){
        setChanged();
        notifyObservers(order);
    }
}
