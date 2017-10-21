package sda.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sda.spring.model.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    Citizen findByName(String name);

    @Query("SELECT COUNT (c) FROM Citizen c where SIZE (c.heroes)> 2 ")
    int countWhoCanCallMoreThan2();
}
