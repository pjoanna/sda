package sda.spring.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import sda.spring.model.KursDto;
@Service
public class KursService {
	
	private Map<String, KursDto> data = new ConcurrentHashMap<>();
	
	public void dodajKurs(KursDto dto){
		this.data.put(dto.getName(), dto);
	}

	public boolean exists(String nazwa) {
		return data.containsKey(nazwa);
	}

	public void edytuj(String nazwa, KursDto dto) {
		this.data.put(nazwa, dto);
	}

	public void usun(String nazwa) {
		data.remove(nazwa);
	}

	public KursDto get(String nazwa) {
		return data.get(nazwa);
	}
	

}
