package sda.spring.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import sda.spring.map.UserMapping;
import sda.spring.model.UserDto;
import sda.spring.service.CourseDao;
import sda.spring.service.UserDao;
import sda.spring.validator.CourseValidator;
import sda.spring.validator.UserValidator;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserCourseController {

    @Autowired
    UserValidator userValidator;

    @Autowired
    CourseDao courseDao;

    @Autowired
    UserDao userDao;

    @Autowired
    UserMapping userMapping;

    @InitBinder
    public void dataBinding(WebDataBinder binder){
        binder.addValidators(userValidator);
    }

    @RequestMapping(value = "/addUserToCourseProcess", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Dodaję użytkowników do kursu.", notes = "", response = Void.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Użytkownicy dodani", response = Void.class),
            @ApiResponse(code = 401, message = "Nie udało się dodać użytkowników", response = Void.class)})
    public ResponseEntity<Boolean> addCourse(@ApiParam(value = "Dodawanie userów") @RequestParam(value = "name") String courseName, @Valid @RequestBody UserDto userDto) {
        boolean b = courseDao.addUserToCourse(courseName, userMapping.mapToUser(userDto));
        return new ResponseEntity<>(b, HttpStatus.OK);
    }


}
