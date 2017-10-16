package sda.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import sda.spring.model.LoginDto;
import sda.spring.model.UserDto;
import sda.spring.service.UserDao;
import sda.spring.validator.UserValidator;

@RestController
public class LoginController {
	
	@Autowired
	UserDao userService;

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Loguje usera.", notes = "", response = Void.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User zalogowany", response = Void.class),
			@ApiResponse(code = 401, message = "Logowanie nieudane", response = Void.class) })
	public ResponseEntity<Void> loginProcess(@ApiParam(value = "Dane logowania") @RequestBody LoginDto login) {
		UserDto user = userService.validateUser(login);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} 
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
