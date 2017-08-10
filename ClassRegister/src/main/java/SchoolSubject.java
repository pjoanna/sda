import java.util.List;
import java.util.Map;

/**
 * Created by pjoanna on 2017-08-09.
 */
public class SchoolSubject {
    private Map<Integer, List<Grade>> gradeMap;

    public void addGrade(Integer id, Grade grade){
      //  gradeMap.put(id, );
    }

    public void displayAllGrades(){
        for (Map.Entry<Integer, List<Grade>> entry : gradeMap.entrySet()) {
            System.out.println("uczeń: " + entry.getKey() + " posiada oceny: ");
            for (Grade grade : entry.getValue()) {
                System.out.print(grade.getGrade() + " ");
            }
        }
    }

    public void displayStudentGrades(Student student){
        for (Map.Entry<Integer, List<Grade>> entry : gradeMap.entrySet()) {
         //   if (entry.getKey())
        }

    }
}
