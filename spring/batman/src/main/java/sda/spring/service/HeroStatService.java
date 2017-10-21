package sda.spring.service;

import org.springframework.stereotype.Service;
import sda.spring.model.HeroStat;
import sda.spring.repository.CitizenRepository;
import sda.spring.repository.HeroStatRepository;
import sda.spring.repository.SuperHeroRepository;

import java.util.Date;

@Service
public class HeroStatService {
    private HeroStatRepository heroStatRepository;
    private CitizenRepository citizenRepository;
    private SuperHeroRepository superHeroRepository;

    public void heroCalled(String citizenName, String superHeroName){
        HeroStat stats = new HeroStat();
        stats.setCallDate(new Date());
        stats.setCitizen(citizenRepository.findByName(citizenName));
        stats.setSuperHero(superHeroRepository.findByName(superHeroName));
    }
}
