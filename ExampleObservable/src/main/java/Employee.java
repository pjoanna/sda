import java.util.Observer;

/**
 * Created by RENT on 2017-08-10.
 */
public class Employee implements Observer {
    private static int counter = 0;

    private int id = counter++;

    public Employee() {
    }

    @Override
    public void update(java.util.Observable o, Object arg) {

        if (arg instanceof String) {
            String castedNews = (String) arg;

            System.out.println(id + " powiadomiony o " + castedNews);

        }
    }
}
