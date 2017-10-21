package sda.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sda.spring.model.Kurs;

@Repository
public interface KursRepository extends JpaRepository<Kurs, Long>{

	int countByName(String name);

	Kurs findByName(String name);

}
