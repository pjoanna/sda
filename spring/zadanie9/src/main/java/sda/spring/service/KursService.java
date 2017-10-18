package sda.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.spring.model.Kurs;
import sda.spring.repository.KursRepository;

import java.util.List;

public interface KursService {


    List<Kurs> findByName(String courseName);

    void addCourse(Kurs kurs);

}
