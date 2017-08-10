import java.util.LinkedList;
import java.util.List;

/**
 * Created by RENT on 2017-08-10.
 */
public class AsteriskSingleton {
    private final static AsteriskSingleton instance = new AsteriskSingleton();

    private AsteriskSingleton(){
    }

    public static AsteriskSingleton getInstance(){
        return instance;
    }

    public void call(){

    }

    public List<String> getCalls(){
        return new LinkedList<>();
    }
}
