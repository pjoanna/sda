import java.util.Observable;

/**
 * Created by pjoanna on 2017-08-13.
 */
public class Student extends Person{
    public Student(String name, String surname) {
        super(name, surname, PersonType.STUDENT);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Integer){
            Integer grade = (Integer) arg;
            System.out.println("tylko żeby nie było jedynki! a jest: " + grade);
        }

    }
}
