package sda.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sda.spring.model.Course;
import sda.spring.model.CourseDto;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseName(String courseName);

    @Query("SELECT c from Course c WHERE c.courseName = :courseName")
    Course oofindByNameSelect(@Param("courseName")String courseName);

    @Query(value="SELECT * from Course c WHERE c.courseName = :courseName",nativeQuery=true)
    Course oofindByNameNative(@Param("courseName")String courseName);

 //   Course findByCourseNameAndUsers();

}
