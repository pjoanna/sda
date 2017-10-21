package sda.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.spring.model.BatmanException;
import sda.spring.model.Citizen;
import sda.spring.model.SuperHero;
import sda.spring.repository.CitizenRepository;
import sda.spring.repository.SuperHeroRepository;

@Service
public class SuperHeroService {
    private SuperHeroRepository superHeroRepository;
    private CitizenRepository citizenRepository;

    @Autowired
    public SuperHeroService(SuperHeroRepository superHeroRepository, CitizenRepository citizenRepository) {
        this.superHeroRepository = superHeroRepository;
        this.citizenRepository = citizenRepository;
    }

    public SuperHero findById(Long id) {
        return superHeroRepository.findOne(id);
    }

    public SuperHero create(SuperHero superHero) {
        return superHeroRepository.save(superHero);
    }

    public SuperHero update(Long id, SuperHero edited) {
        SuperHero original = superHeroRepository.findOne(id);
        if (original != null) {
            original.setName(edited.getName());
            return superHeroRepository.save(original);
        }
        return null;
    }

    public void deleteById(Long id) {
        SuperHero hero = superHeroRepository.findOne(id);
        if (hero != null && hero.getName().equals("Batman")){
            throw new BatmanException("You shall not remove Batman!");
        }
        superHeroRepository.delete(id);
    }

    public void link(String superHeroName, String citizenName){
        SuperHero superHero = superHeroRepository.findByName(superHeroName);
        Citizen citizen = citizenRepository.findByName(citizenName);
        if (citizen == null || superHero == null){
            throw new IllegalArgumentException("citizen or hero not found");
        }
        superHero.getCitizens().add(citizen);
        citizen.getHeroes().add(superHero);
        superHeroRepository.save(superHero);
        citizenRepository.save(citizen);

    }
}
