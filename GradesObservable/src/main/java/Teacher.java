import java.util.Observable;

/**
 * Created by pjoanna on 2017-08-13.
 */
public class Teacher extends Person{
    public Teacher(String name, String surname) {
        super(name, surname, PersonType.TEACHER);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Integer){
            Integer grade = (Integer) arg;
            System.out.println("uwaga! tu nauczyciel. wstawiam ocenę " + grade);
        }

    }
}
