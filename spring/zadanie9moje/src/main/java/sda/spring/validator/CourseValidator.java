package sda.spring.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sda.spring.model.CourseDto;
import sda.spring.model.UserDto;
import sda.spring.service.CourseDao;
import sda.spring.service.UserDao;

@Component
public class CourseValidator implements Validator {

    @Autowired
    CourseDao courseDao;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == CourseDto.class;
    }

    @Override
    public void validate(Object obj, Errors errors) {
        if(obj instanceof CourseDto){
            CourseDto course = (CourseDto) obj;
            CourseDto found = courseDao.getCourseDto(course.getName());
            if(found != null){
                errors.reject("courseName");
            }
        }
    }
}