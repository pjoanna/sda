package sda.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.spring.model.SuperHero;
import sda.spring.repository.SuperHeroRepository;

@Service
public class SuperHeroService {
    private SuperHeroRepository superHeroRepository;

    @Autowired
    public SuperHeroService(SuperHeroRepository superHeroRepository) {
        this.superHeroRepository = superHeroRepository;
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
        superHeroRepository.delete(id);
    }
}
