package sda.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.spring.model.Kurs;
import sda.spring.model.User;

import java.util.List;

public interface KursRepository extends JpaRepository<Kurs, Long> {

    List<Kurs> findByName(String courseName);
}

