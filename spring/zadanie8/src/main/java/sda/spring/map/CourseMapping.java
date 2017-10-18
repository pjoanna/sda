package sda.spring.map;

import sda.spring.model.Course;
import sda.spring.model.CourseDto;

public class CourseMapping {
    public static Course mapToCourse(CourseDto courseDto) {
        Course entity = new Course();
        entity.setName(courseDto.getName());
        entity.setEnd(courseDto.getEnd());
        entity.setStart(courseDto.getStart());
        entity.setMaxParticipants(courseDto.getMaxParticipants());
        return entity;
    }

    public static CourseDto mapToCourseDto(Course course) {
        CourseDto dto = new CourseDto();
        dto.setName(course.getName());
        dto.setEnd(course.getEnd());
        dto.setStart(course.getStart());
        dto.setMaxParticipants(course.getMaxParticipants());
        return dto;
    }
}
