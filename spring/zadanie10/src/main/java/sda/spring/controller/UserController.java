package sda.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import sda.spring.model.LoginDto;
import sda.spring.model.User;
import sda.spring.model.UserDto;
import sda.spring.service.TokenAuthenticationService;
import sda.spring.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private TokenAuthenticationService tokenService;

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Loguje usera.", notes = "", response = Void.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User zalogowany", response = Void.class),
			@ApiResponse(code = 401, message = "Logowanie nieudane", response = Void.class) })
	public ResponseEntity<String> loginProcess(@ApiParam(value = "Dane logowania") @RequestBody LoginDto login) {
		String token = tokenService
				.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
		if (StringUtils.isEmpty(token)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(token, HttpStatus.OK);
	}

	@RequestMapping(value = "/getByPassword", method = RequestMethod.GET)
	@ApiOperation(value = "Znajduje wszystkich", notes = "", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Udalo sie", response = List.class) })
	public ResponseEntity<List<User>> findAll(@ApiParam("haslo") @RequestParam("haslo") String haslo) {
		List<User> users = userService.findByPassword(haslo);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/zapiszNaKurs/{kurs}", method = RequestMethod.PUT)
	@ApiOperation(value = "Zapisuje usera na kurs", notes = "", response = Void.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Udalo sie", response = Void.class),
			@ApiResponse(code = 404, message = "Kurs nieznaleziony", response = Void.class) })
	@Secured("kursant")
	public ResponseEntity<List<User>> addToCourse(@ApiParam("haslo") @RequestParam("kurs") String courseName) {
		// List<User> users = userService.findByPassword(haslo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
