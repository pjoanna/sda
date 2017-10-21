package sda.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.spring.model.SuperHero;

@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {
}
