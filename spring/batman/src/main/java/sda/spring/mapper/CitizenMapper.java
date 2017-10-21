package sda.spring.mapper;

import org.springframework.stereotype.Component;
import sda.spring.model.Citizen;
import sda.spring.model.CitizenDto;
import sda.spring.model.SuperHero;
import sda.spring.model.SuperHeroDto;

@Component
public class CitizenMapper {
    public Citizen map(CitizenDto dto){
        Citizen entity = new Citizen();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public CitizenDto map(Citizen entity){
        CitizenDto dto = new CitizenDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
