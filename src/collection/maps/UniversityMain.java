package collection.maps;

/**
 * Created by RENT on 2017-07-18.
 */
public class UniversityMain {
    public static void main(String[] args) {
        University university = new University();
        university.addStudent(100L, "S","M");
        university.containsStudent(100L);
        university.getStudent(100L);
        university.printAllStudent();
        university.studentsCount();
        university.getStudent(1000L);

    }
}
