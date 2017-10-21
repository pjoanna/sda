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
import sda.spring.mapper.SuperHeroMapper;
import sda.spring.model.SuperHero;
import sda.spring.model.SuperHeroDto;
import sda.spring.service.SuperHeroService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/superHero")
public class SuperHeroController {
    @Autowired
    private SuperHeroService superHeroService;
    @Autowired
    SuperHeroMapper mapper;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponse(code = 200, message = "Bohater utworzony")
    @ApiOperation(value = "Tworzy bohatera", response = Long.class)
    public ResponseEntity<Long> createSuperHero(@ApiParam("Tworzony bohater") @RequestBody @Valid SuperHeroDto hero) {
        SuperHero createdHero = superHeroService.create(mapper.map(hero));
        return ResponseEntity.ok(createdHero.getId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Bohater pobrany"),
            @ApiResponse(code = 404, message = "Bohater nie istnieje")
    })
    @ApiOperation(value = "Pobiera bohatera", response = SuperHeroDto.class)
    public ResponseEntity<SuperHeroDto> getSuperHero(@PathVariable("id") @ApiParam("id bohatera") Long id) {
        SuperHero hero = superHeroService.findById(id);
        if (hero == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(mapper.map(hero));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Bohater edytowany"),
            @ApiResponse(code = 404, message = "Bohater nie istnieje")
    })
    @ApiOperation(value = "Edytuje bohatera", response = Void.class)
    public ResponseEntity<Void> updateSuperHero(@ApiParam("Id bohatera")@PathVariable("id") Long id,
                                                @ApiParam("Edytowany bohater") @RequestBody @Valid SuperHeroDto hero) {
        SuperHero updated = superHeroService.update(id, mapper.map(hero));
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Bohater usuniety"),
            @ApiResponse(code = 404, message = "Nie udalo sie usunac  bohatera")
    })
    @ApiOperation(value = "Usuwanie bohatera", response = Void.class)
    public ResponseEntity<Void> removeSuperHero(@ApiParam("Id bohatera") @PathVariable("id") Long id){
        superHeroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{name}/link", method = RequestMethod.PUT)
    @ApiResponse(code = 200, message = "bohater połączony")
    @ApiOperation(value = "łączy bohatera z obywatelem", response = Void.class)
    public ResponseEntity<Void> linkWithCitizen(@ApiParam("nazwa bohatera")@PathVariable("name") String heroName,
                                                @ApiParam("Nazwa mieszkanca") @RequestParam("citizenName") String citizenName) {
        superHeroService.link(heroName, citizenName);
        return ResponseEntity.ok().build();
    }



}
