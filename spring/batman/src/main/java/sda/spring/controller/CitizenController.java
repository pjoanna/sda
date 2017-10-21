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
import sda.spring.mapper.CitizenMapper;
import sda.spring.mapper.SuperHeroMapper;
import sda.spring.model.Citizen;
import sda.spring.model.CitizenDto;
import sda.spring.model.SuperHero;
import sda.spring.model.SuperHeroDto;
import sda.spring.service.CitizenService;
import sda.spring.service.SuperHeroService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/citizen")
public class CitizenController {
    @Autowired
    private CitizenService citizenService;
    @Autowired
    CitizenMapper mapper;
    @Autowired
    SuperHeroService superHeroService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponse(code = 200, message = "obywatel utworzony")
    @ApiOperation(value = "Tworzy obywatela", response = Long.class)
    public ResponseEntity<Long> createCitizen(@ApiParam("Tworzony obywatel") @RequestBody @Valid CitizenDto citizenDto) {
        Citizen citizenCreated= citizenService.create(mapper.map(citizenDto));
        return ResponseEntity.ok(citizenCreated.getId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "obywatel pobrany"),
            @ApiResponse(code = 404, message = "obywatel nie istnieje")
    })
    @ApiOperation(value = "Pobiera bohatera", response = CitizenDto.class)
    public ResponseEntity<CitizenDto> getCitizen(@PathVariable("id") @ApiParam("id obywatela") Long id) {
        Citizen citizen = citizenService.getById(id);
        if (citizen == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(mapper.map(citizen));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "obywatel edytowany"),
            @ApiResponse(code = 404, message = "obywatel nie istnieje")
    })
    @ApiOperation(value = "Edytuje bohatera", response = Void.class)
    public ResponseEntity<Void> updateSuperHero(@ApiParam("Id obywatela")@PathVariable("id") Long id,
                                                @ApiParam("Edytowany obywatel") @RequestBody @Valid CitizenDto citizen) {
        Citizen updated = citizenService.update(id, mapper.map(citizen));
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "obywatel usuniety"),
            @ApiResponse(code = 404, message = "Nie udalo sie usunac  obywatela")
    })
    @ApiOperation(value = "Usuwanie bohatera", response = Void.class)
    public ResponseEntity<Void> removeSuperHero(@ApiParam("Id obywatela") @PathVariable("id") Long id){
        citizenService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{name}/call", method = RequestMethod.GET)
    @ApiResponse(code = 200, message = "bohater przywołany")
    @ApiOperation(value = "bohatera wzywany przez obywatela", response = Void.class)
    public ResponseEntity<SuperHeroDto> call(@ApiParam("nazwa bohatera")@PathVariable("name") String heroName,
                                             @ApiParam("Nazwa mieszkanca") @RequestParam("citizenName") String citizenName) {
        SuperHero superHero = citizenService.getLinkedHero(heroName, citizenName);
        if (superHero == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/usersThatCanCallMoreThan2", method = RequestMethod.GET)
    @ApiResponse(code = 200, message = "Obliczenia udane")
    @ApiOperation(value = "oblicza ile osób moze wezwac wiecej niz 2", response = Integer.class)
    public ResponseEntity<Integer> getSuperHero() {
           return ResponseEntity.ok(citizenService.countWhoCanCallMoreThan2());
    }
}
