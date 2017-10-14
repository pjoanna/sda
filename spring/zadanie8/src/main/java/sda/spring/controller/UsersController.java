package sda.spring.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.spring.model.LoginDto;
import sda.spring.model.UserDto;
import sda.spring.service.UserDao;

@RestController
public class UsersController {

    @Autowired
    UserDao userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Wyświetla usera.", notes = "", response = UserDto.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "User znaleziony", response = UserDto.class),
            @ApiResponse(code = 404, message = "nieudane wyszukiwanie", response = Void.class) })
    public ResponseEntity<UserDto> loginProcess(@ApiParam(value = "Dane logowania") @RequestParam("id") String login) {
        UserDto user = userService.getUserDto(login);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserDto>(user, HttpStatus.OK);
    }
}
