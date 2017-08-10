import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

/**
 * Created by RENT on 2017-08-10.
 */
public class McDonald extends Observable {

    private List<Employee> employeeList = new LinkedList<>();
    public McDonald() {
        for(int i=0; i < 10; i++){
            Employee e = new Employee();
            employeeList.add(e);

            //
            addObserver(e);
//            deleteObserver(e);
        }
}

    public void handleOrder(String order){
        setChanged();
        notifyObservers(order);
    }
}
