package sda.spring.repository;

import sda.spring.model.Course;

import java.util.List;

public interface CourseRepositoryCustom {
    public List<Course> findByAnything(String term);
}
