package sda.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.spring.model.Kurs;
import sda.spring.repository.KursRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class KursServieImpl implements KursService {

    @Autowired
    private KursRepository kursRepository;

    @Override
    public List<Kurs> findByName(String courseName) {

        return kursRepository.findByName(courseName);
    }

    @Transactional
    public void addCourse(Kurs kurs) {

        kursRepository.save(kurs);
    }
}
