package collection.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RENT on 2017-07-17.
 */
public class University implements StudentFormat{
    private Map<Long,Student> studentMap = new HashMap<>();

    public void addStudent(long indexNumber, String name, String surname){
        Student student = new Student(indexNumber, name, surname);
        studentMap.put(indexNumber, student);
    }
    public boolean containsStudent(long indexNumber){
        boolean value = studentMap.containsKey(indexNumber);
        return value;
    }
    public Student getStudent(long indexNumber){
        Student student = studentMap.get(indexNumber);
        if(student==null){
            System.out.println("Nie ma studenta o numerze indeksu: "+indexNumber);
            throw new NoSuchStudentException();
        }
        return studentMap.get(indexNumber);
    }

    public int studentsCount(){
        int studentCount = studentMap.size();
        return studentCount;
    }

    public void printAllStudent(){
        System.out.println("Wszyscy studenci: ");
        for (Student student : studentMap.values()) {
            System.out.println(student);
        }
        System.out.println(studentMap.values());
    }

    @Override
    public String format(Student student) {
        String info = student.toString();
        return info;
    }
}
