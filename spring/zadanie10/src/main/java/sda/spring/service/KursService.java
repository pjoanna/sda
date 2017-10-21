package sda.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sda.spring.model.Kurs;
import sda.spring.repository.KursRepository;
@Service
public class KursService {
	
	@Autowired
	KursRepository kursRepository;
	
	public void dodajKurs(Kurs kurs){
		this.kursRepository.save(kurs);
	}

	public boolean exists(String nazwa) {
		return kursRepository.countByName(nazwa) > 0;
	}

	public void edytuj(Kurs zmienionyKurs) {
		Kurs kurs = this.kursRepository.findByName(zmienionyKurs.getName());
//		kurs.setFrom(zmienionyKurs.getFrom());
		kurs.setMaxParticipants(zmienionyKurs.getMaxParticipants());
//		kurs.setTo(zmienionyKurs.getTo());
		this.kursRepository.save(kurs);
	}

	public void usun(String nazwa) {
		this.kursRepository.delete(this.kursRepository.findByName(nazwa));
	}

	public Kurs get(String nazwa) {
		return this.kursRepository.findByName(nazwa);
	}
	

}
