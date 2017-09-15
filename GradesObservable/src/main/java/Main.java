import java.util.ArrayList;
import java.util.List;

/**
 * Created by pjoanna on 2017-08-13.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> integerGrades = new ArrayList<>();
        Grades grades = new Grades(integerGrades);
        createPeopleOnStart(grades);
        grades.addGrade(3);
    }


    private static void createPeopleOnStart(Grades grades) {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            Teacher teacher = new Teacher("t", "teacher" + counter++);
            Student student = new Student("s", "student" + counter++);
            Parent parent = new Parent("p", "parent" + counter++);
            grades.addObserver(teacher);
            grades.addObserver(parent);
            grades.addObserver(student);
        }
    }
}
