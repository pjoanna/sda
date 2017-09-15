import java.util.Observable;

/**
 * Created by pjoanna on 2017-08-13.
 */
public class Parent extends Person{
    public Parent(String name, String surname) {
        super(name, surname, PersonType.PARENT);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Integer){
            Integer grade = (Integer) arg;
            System.out.println("o! ale ocena" + grade);
        }
    }
}
