package sda.spring.service;

import org.springframework.stereotype.Service;
import sda.spring.model.CourseDto;
import sda.spring.repository.CourseRepository;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class CourseDaoImpl implements CourseDao {
    private ConcurrentHashMap<String, CourseDto> data = new ConcurrentHashMap<>();

    private CourseRepository repository;

    @Override
    public void add(CourseDto courseDto) {
        data.put(courseDto.getName(), courseDto);
    }

    @Override
    public CourseDto validateCourse(String name) {
        CourseDto courseDto = data.get(name);
        return courseDto;
    }

    @Override
    public CourseDto getCourseDto(String name) {
        return data.get(name);
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
