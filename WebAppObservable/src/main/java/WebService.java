import java.util.Observable;

/**
 * Created by RENT on 2017-08-12.
 */
public class WebService extends Observable {

    public WebService() {
        addObserver(new Marketing());
        addObserver(new ServiceDepartment());
    }

    public void handleRequest(Request req) {
        System.out.println("Request arrived: " + req);

        // writing requests to database
        Database.INSTANCE.saveToDatabase(DatabaseType.DB_REQUESTS, req);

        // notify observers
        setChanged();
        notifyObservers(req);
    }
}
