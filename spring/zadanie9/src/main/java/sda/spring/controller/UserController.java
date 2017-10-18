package sda.spring.controller;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sda.spring.model.User;
import sda.spring.model.UserDto;
import sda.spring.service.UserService;
import java.util.ArrayList;
import java.util.List;


                            // Krok 6.
                            // Dodajemy koniecznie adnotację @RestController
                            // Wstrzykujemy interfejs UserService

@RestController
public class UserController {

    @Autowired
    UserService userService;

    // Tworzymy metody z UserServiceImpl:

    @RequestMapping(value = "/findByPassword", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Szuka usera po haśle.", notes = "", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "User znaleziony", response = List.class),
            @ApiResponse(code = 401, message = "nie znaleziono", response = Void.class) })
    public ResponseEntity<List> findByPassword(@ApiParam(value = "szukane hasło") @RequestParam("password") String password) {
        List<User> listUsers= userService.findByPassword(password);
        List<UserDto> listUsersDto = new ArrayList<>();
        for (User u: listUsers){
            listUsersDto.add(map(u));
        }

        return new ResponseEntity<>(listUsersDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/findByFirstnameAndPassword", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Szuka usera po imieniu i haśle.", notes = "", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "User znaleziony", response = List.class),
            @ApiResponse(code = 401, message = "nie znaleziono", response = Void.class) })
    public ResponseEntity<List> findByFirstnameAndPassword(@ApiParam(value = "szukane imie") @RequestParam ("firstName")  String firstName, @ApiParam(value = "szukane hasło") @RequestParam ("password") String password) {
        List<User> listUsers= userService.findByFirstnameAndPassword(firstName,password);
        List<UserDto> listUsersDto = new ArrayList<>();
        for (User u: listUsers){
            listUsersDto.add(map(u));
        }
        if (listUsers.isEmpty()){
            return new ResponseEntity<List>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listUsersDto, HttpStatus.OK);
    }

    // Tej mapy używamy w powyższych metodach aby pobierać / zapisywać odpowiednie dane

    private UserDto map(User user) {
        UserDto userDto = new UserDto();
        userDto.setAddress(user.getAddress());
        userDto.setEmail(user.getEmail());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setPassword(user.getPassword());
        userDto.setPhone(user.getPhone());
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    // -> Idź do Application żeby uruchomić aplikację
}
