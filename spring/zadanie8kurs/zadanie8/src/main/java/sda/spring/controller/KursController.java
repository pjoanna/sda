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
import sda.spring.model.KursDto;
import sda.spring.model.LoginDto;
import sda.spring.model.UserDto;
import sda.spring.service.KursService;
import sda.spring.service.UserDao;
import sda.spring.validator.KursValidator;
import sda.spring.validator.UserValidator;

@RestController
@RequestMapping(value = "/kurs")
public class KursController {
	
	@Autowired
	KursService kursService;
	
	@Autowired
	KursValidator validator;
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		binder.addValidators(validator);
	}


	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Dodaje kurs.", notes = "", response = Void.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Kurs dodany", response = Void.class),
			@ApiResponse(code = 401, message = "Nie udalo sie dodac kursu", response = Void.class) })
	public ResponseEntity<Void> addKurs(@ApiParam(value = "Dane kursu") @Valid @RequestBody KursDto dto) {
		kursService.dodajKurs(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@RequestMapping(value = "/{nazwa}", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Zmienia kurs.", notes = "", response = Void.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Kurs zmieniony", response = Void.class),
			@ApiResponse(code = 404, message = "Nie znaleziono kursu", response = Void.class) })
	public ResponseEntity<Void> editKurs(@ApiParam(value = "Nazwa zmienianego kursu") @RequestParam("nazwa") String nazwa, @ApiParam(value = "Nowe dane kursu") @RequestBody KursDto dto) {
		if(kursService.exists(nazwa)){
			kursService.edytuj(nazwa, dto);
			return new ResponseEntity<>(HttpStatus.OK);
		};
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@RequestMapping(value = "/{nazwa}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Usuwa kurs o podanej nazwie", notes = "", response = Void.class)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Kurs usuniety", response = Void.class),
			@ApiResponse(code = 404, message = "Nie znaleziono kursu", response = Void.class) })
	public ResponseEntity<Void> deleteKurs(@ApiParam(value = "Nazwa zmienianego kursu") @RequestParam("nazwa") String nazwa) {
		if(kursService.exists(nazwa)){
			kursService.usun(nazwa);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		};
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@RequestMapping(value = "/{nazwa}", method = RequestMethod.GET)
	@ApiOperation(value = "Pobiera kurs po nazwie", notes = "", response = KursDto.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Kurs pobrany poprawnie", response = KursDto.class),
			@ApiResponse(code = 404, message = "Nie znaleziono kursu", response = KursDto.class) })
	public ResponseEntity<KursDto> getKurs(@ApiParam(value = "Nazwa pobieranego kursu") @RequestParam("nazwa") String nazwa) {
		if(kursService.exists(nazwa)){
			KursDto kurs = kursService.get(nazwa);
			return new ResponseEntity<>(kurs, HttpStatus.OK);
		};
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
