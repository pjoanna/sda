package collection.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by RENT on 2017-07-17.
 */

public class MapStudentTree {
    public static void main(String[] args) {
        Student[] students = {
                new Student(10020L,"Adam","Biały"),
                new Student(10040L, "Aleks","Nowak"),
                new Student(10030L, "Dariusz","Kowal")
        };
        Map<Long, Student> studentMap = new TreeMap<>();
        for (Student student : students) {
            studentMap.put(student.getIndexNumber(),student);
        }

        System.out.println(studentMap.values());
        System.out.println(studentMap.get(10020L));
        System.out.println("Liczba studentów to "+studentMap.size());

        System.out.println("Wszyscy studenci 1");
        for (Student student : studentMap.values()) {
            System.out.println(student);

        }
        System.out.println("Wszyscy studenci 2");
        System.out.println(studentMap.values());


    }
}
