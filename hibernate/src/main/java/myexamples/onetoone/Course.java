package myexamples.onetoone;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by RENT on 2017-09-28.
 */
@Entity
public class Course {
    @Id
    private int id;
    private String title;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "STUDENT_ID")
    private Collection<Student> students = new ArrayList<>();

    public Course(String title, Collection<Student> students) {
        this.title = title;
        this.students = students;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", students=" + students +
                '}';
    }
}
