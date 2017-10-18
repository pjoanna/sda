package sda.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.spring.model.Course;
import sda.spring.model.CourseDto;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByName(String courseName);

    Course validateCourse(String name);

}
