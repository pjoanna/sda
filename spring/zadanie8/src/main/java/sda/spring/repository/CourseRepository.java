package sda.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.spring.model.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByName(String courseName);

}
