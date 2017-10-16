package sda.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import sda.spring.model.UserDto;
import sda.spring.service.UserDao;
import sda.spring.validator.UserValidator;

@RestController
public class RegistrationController {

	@Autowired
	public UserDao userService;
	
	@Autowired
	UserValidator validator;
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		binder.addValidators(validator);
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE },consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Rejestruje usera.", notes = "", response = Void.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User zarejestrowany", response = Void.class),
			@ApiResponse(code = 400, message = "Niepoprawne dane wejœciowe", response = Void.class) })
	public ResponseEntity<Void> addUser(@ApiParam(value = "Rejestrowany user") @Valid @RequestBody UserDto user) {
		userService.register(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE },consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Rejestruje usera.", notes = "", response = Void.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User zarejestrowany", response = Void.class),
			@ApiResponse(code = 400, message = "Niepoprawne dane wejœciowe", response = Void.class) })
	public ResponseEntity<Void> getUser(@ApiParam(value = "Rejestrowany user") @Valid @RequestParam("id") UserDto user) {
		userService.register(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}