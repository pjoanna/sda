package sda.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import sda.spring.model.Course;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Course> findByAnything(String term) {
        Query query = entityManager.createQuery("select c from course c where c.courseName = ?");
        query.setParameter(1, term);
        return query.getResultList();
    }

}
