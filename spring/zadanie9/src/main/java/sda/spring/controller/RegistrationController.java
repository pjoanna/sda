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
import sda.spring.model.User;
import sda.spring.model.UserDto;
import sda.spring.service.UserService;

@RestController
public class RegistrationController {

	@Autowired
	public UserService userService;

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE },consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Rejestruje usera.", notes = "", response = Void.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User zarejestrowany", response = Void.class),
			@ApiResponse(code = 400, message = "Niepoprawne dane wejściowe", response = Void.class) })
	public ResponseEntity<Void> addUser(@ApiParam(value = "Rejestrowany user") @RequestBody UserDto user) {
		userService.register(map(user));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	private User map(UserDto user) {
		User entity = new User();
		entity.setAddress(user.getAddress());
		entity.setEmail(user.getEmail());
		entity.setFirstname(user.getFirstname());
		entity.setLastname(user.getLastname());
		entity.setPassword(user.getPassword());
		entity.setPhone(user.getPhone());
		entity.setUsername(user.getUsername());
		return entity;
	}
}