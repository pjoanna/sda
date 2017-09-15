import java.util.List;
import java.util.Observable;

/**
 * Created by pjoanna on 2017-08-13.
 */
public class Grades extends Observable {
    private List<Integer> grades;

    public Grades(List<Integer> grades) {
        this.grades = grades;
    }

    public void addGrade(Integer grade){
        grades.add(grade);
        setChanged();
        notifyObservers(grade);
    }

}
