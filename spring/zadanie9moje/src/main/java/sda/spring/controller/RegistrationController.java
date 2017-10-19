package sda.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import sda.spring.model.UserDto;
import sda.spring.service.UserDao;
import sda.spring.validator.CourseValidator;

@RestController
public class RegistrationController {

	@Autowired
	public UserDao userService;

	@RequestMapping(value = "/registerProcess",
			method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE },
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Rejestruje usera.", notes = "", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "User zarejestrowany", response = Void.class),
			@ApiResponse(code = 400, message = "Niepoprawne dane wej�ciowe", response = Void.class)
	})
	public ResponseEntity<Void> addUser(@ApiParam(value = "Rejestrowany user") @RequestBody UserDto user) {
		userService.register(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/getProcess",
			method = RequestMethod.GET)
	@ApiOperation(value = "get.", notes = "", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "get200", response = Void.class),
			@ApiResponse(code = 400, message = "get400", response = Void.class)
	})
	public ResponseEntity<Void> getMethod() {
        System.out.println("get działa");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}