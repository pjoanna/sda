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
import sda.spring.model.Kurs;
import sda.spring.model.KursDto;
import sda.spring.model.User;
import sda.spring.model.UserDto;
import sda.spring.service.KursService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class KursController {

    @Autowired
    public KursService kursService;

    @RequestMapping(value = "/findByName", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Szuka Kursu", notes = "", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "kurs znaleziony", response = List.class),
            @ApiResponse(code = 401, message = "nie znaleziono", response = List.class) })
    public ResponseEntity<List> findByPassword(@ApiParam(value = "szukana nazwa kursu") @RequestParam("nazwa Kursu") String courseName) {
        List<Kurs> listaKursow = kursService.findByName(courseName);
        List<KursDto> listKursDto = new ArrayList<>();
        for (Kurs k : listaKursow) {
            listKursDto.add(map(k));
        }

        return new ResponseEntity<>(listKursDto, HttpStatus.OK);
    }


    @RequestMapping(value = "/courseAddProcess", method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_JSON_VALUE },consumes=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Dodaje kurs.", notes = "", response = Void.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Kurs dodany", response = Void.class),
            @ApiResponse(code = 400, message = "Niepoprawne dane wejściowe", response = Void.class) })
    public ResponseEntity<Void> addUser(@ApiParam(value = "Dodawany kurs") @RequestBody KursDto kursDto) {
        kursService.addCourse(map2(kursDto));
        return  new ResponseEntity<Void>(HttpStatus.OK);

    }

    private KursDto map(Kurs kurs) {

        KursDto kursDto = new KursDto();
        kursDto.setName("IT na Bank");
        kursDto.setMaxParticipants(15);
        return kursDto;
    }

    private Kurs map2(KursDto kursDto) {

        Kurs kurs = new Kurs();
        kurs.setName("IT na Bank");
        kurs.setMaxParticipants(15);
        return kurs;
    }
}
