package sda.spring.service;

import sda.spring.model.CourseDto;
import sda.spring.model.LoginDto;
import sda.spring.model.UserDto;

public interface CourseDao {
    void add(CourseDto courseDto);

    CourseDto validateCourse(String name);

    CourseDto getCourseDto(String name);

    void remove(CourseDto courseDto);

    void update(String name, CourseDto courseDto);
}
