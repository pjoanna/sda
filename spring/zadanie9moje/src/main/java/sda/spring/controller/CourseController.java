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
import sda.spring.model.CourseDto;
import sda.spring.model.UserDto;
import sda.spring.service.CourseDao;
import sda.spring.validator.CourseValidator;

import javax.validation.Valid;

@RestController
public class CourseController {

    @Autowired
    CourseValidator courseValidator;

    @Autowired
    CourseDao courseDao;

    @InitBinder
    public void dataBinding(WebDataBinder binder){
        binder.addValidators(courseValidator);
    }


    @RequestMapping(value = "/addCourseProcess", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Dodaję kurs.", notes = "", response = Void.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Kurs dodany", response = Void.class),
            @ApiResponse(code = 401, message = "Nie udało się dodać kursu", response = Void.class)})
    public ResponseEntity<Void> addCourse(@ApiParam(value = "Dodawanie kursu") @Valid @RequestBody CourseDto courseDto) {
        courseDao.add(courseDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/removeCourseProcess", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Usuwam kurs.", notes = "", response = Void.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Kurs usunięty", response = Void.class),
            @ApiResponse(code = 401, message = "Nie udało się usunąć kursu", response = Void.class)})
    public ResponseEntity<Void> removeCourse(@ApiParam(value = "Usuwanie kursu") @RequestBody String name) {
        CourseDto courseDto = courseDao.getCourseDto(name);
        if (courseDto == null){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        courseDao.remove(courseDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/updateCourseProcess/(name)", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update kursu.", notes = "", response = Void.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Kurs updatowany", response = Void.class),
            @ApiResponse(code = 401, message = "Nie udało się updatować kursu", response = Void.class)})
    public ResponseEntity<Void> updateCourse(@ApiParam(value = "Update kursu") @RequestParam(value = "name") String name, @RequestBody CourseDto courseDto) {
        CourseDto courseDtoToUpdate = courseDao.getCourseDto(name);
        if (courseDtoToUpdate == null){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        courseDao.update(name, courseDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Wyświetla kurs.", notes = "", response = CourseDto.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Kurs znaleziony", response = CourseDto.class),
            @ApiResponse(code = 404, message = "nieudane wyszukiwanie", response = Void.class) })
    public ResponseEntity<CourseDto> loginProcess(@ApiParam(value = "Dane logowania") @RequestParam("id") String courseName) {
        CourseDto course = courseDao.getCourseDto(courseName);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CourseDto>(course, HttpStatus.OK);
    }


}
