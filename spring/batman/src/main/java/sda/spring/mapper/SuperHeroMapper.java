package sda.spring.mapper;

import org.springframework.stereotype.Component;
import sda.spring.model.SuperHero;
import sda.spring.model.SuperHeroDto;

@Component
public class SuperHeroMapper {
    public SuperHero map(SuperHeroDto dto){
        SuperHero entity = new SuperHero();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public SuperHeroDto map(SuperHero entity){
        SuperHeroDto dto = new SuperHeroDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
