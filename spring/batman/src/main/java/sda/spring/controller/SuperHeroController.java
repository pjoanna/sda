package sda.spring.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sda.spring.SuperHeroMapper;
import sda.spring.model.SuperHero;
import sda.spring.model.SuperHeroDto;
import sda.spring.service.SuperHeroService;

import javax.validation.Valid;

@RestController
public class SuperHeroController {
    @Autowired
    private SuperHeroService superHeroService;
    @Autowired
    SuperHeroMapper mapper;

    @RequestMapping(value = "/superHero", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponse(code = 200, message = "Bohater utworzony")
    @ApiOperation(value = "Tworzy bohatera", response = Long.class)
    public ResponseEntity<Long> createSuperHero(@ApiParam("Tworzony bohater") @RequestBody @Valid SuperHeroDto hero){
        SuperHero createdHero = superHeroService.create(mapper.map(hero));
        return ResponseEntity.ok(createdHero.getId());
    }
}
