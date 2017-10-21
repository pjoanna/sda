package sda.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.spring.model.BatmanException;
import sda.spring.model.Citizen;
import sda.spring.model.SuperHero;
import sda.spring.repository.CitizenRepository;
import sda.spring.repository.SuperHeroRepository;

@Service
public class CitizenService {
    @Autowired
    CitizenRepository citizenRepository;
    @Autowired
    SuperHeroRepository superHeroRepository;

    public Citizen create(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    public Citizen getById(Long id) {
        return citizenRepository.findOne(id);
    }

    public Citizen update(Long id, Citizen edited) {
        Citizen original = citizenRepository.findOne(id);
        if (original != null) {
            original.setName(edited.getName());
            return citizenRepository.save(original);
        }
        return null;
    }


    public void deleteById(Long id) {
        Citizen original = citizenRepository.findOne(id);
        if (original != null && original.getName().equals("Gordon")) {
            throw new BatmanException("Gordon is protected by Batman!");
        }
        citizenRepository.delete(id);
    }

    public SuperHero getLinkedHero(String superHeroName, String citizenName) {
        SuperHero hero = superHeroRepository.findByName(superHeroName);
        Citizen citizen = citizenRepository.findByName(citizenName);
        if (citizen == null || hero == null) {
            throw new IllegalArgumentException("Hero or citizen does not exist");
        }
        if (citizen.getHeroes().contains(hero)) {
            return hero;
        }
        return null;

    }
    public int countWhoCanCallMoreThan2(){
        return citizenRepository.countWhoCanCallMoreThan2();
    }
}
