package sda.spring.map;

import org.springframework.stereotype.Component;
import sda.spring.model.Course;
import sda.spring.model.CourseDto;

@Component
public class CourseMapping {
    public Course mapToCourse(CourseDto courseDto) {
        Course entity = new Course();
        entity.setName(courseDto.getName());
        entity.setEnd(courseDto.getEnd());
        entity.setStart(courseDto.getStart());
        entity.setMaxParticipants(courseDto.getMaxParticipants());
        return entity;
    }

    public CourseDto mapToCourseDto(Course course) {
        CourseDto dto = new CourseDto();
        dto.setName(course.getName());
        dto.setEnd(course.getEnd());
        dto.setStart(course.getStart());
        dto.setMaxParticipants(course.getMaxParticipants());
        return dto;
    }
}
