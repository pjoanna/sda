package sda.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.spring.map.CourseMapping;
import sda.spring.model.Course;
import sda.spring.model.CourseDto;
import sda.spring.repository.CourseRepository;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class CourseDaoImpl implements CourseDao {
    private ConcurrentHashMap<String, CourseDto> data = new ConcurrentHashMap<>();

    @Autowired
    private CourseRepository repository;
    @Autowired
    private CourseMapping mapping;

    @Override
    public void add(CourseDto courseDto) {
        Course course = mapping.mapToCourse(courseDto);
      //  repository.save(course);
    }

    @Override
    public CourseDto validateCourse(String name) {
        CourseDto courseDto = data.get(name);
        return courseDto;
    }

    @Override
    public CourseDto getCourseDto(String name) {
        Course course = repository.findByName(name);
        if (course == null){
            return null;
        }
        return mapping.mapToCourseDto(course);
    }

    @Override
    public void remove(CourseDto courseDto) {
        data.remove(courseDto);
    }

    @Override
    public void update(String name, CourseDto newCourseDto) {
        CourseDto courseDtoToUpdate = getCourseDto(name);
        add(newCourseDto);
        remove(courseDtoToUpdate);
    }
}
