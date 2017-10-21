package sda.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.spring.model.HeroStat;

@Repository
public interface HeroStatRepository extends JpaRepository<HeroStat, Long>{
}
