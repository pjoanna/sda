import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by pjoanna on 2017-08-09.
 */
public class Classroom {
    private final Set<Student> students = new TreeSet<String>(Comparator.comparing(Integer::valueOf));
    private Map<SubjectType, SchoolSubject> subjectTypeSchoolSubjectMap;

    public void printStudents(){
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
