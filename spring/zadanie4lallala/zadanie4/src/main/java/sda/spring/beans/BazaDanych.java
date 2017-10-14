package sda.spring.beans;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

@Component
public class BazaDanych {
	
	private AtomicLong idGenerator = new AtomicLong();
	private Map<Long, Faktura> baza = new HashMap<>();
	
	public Faktura findById(Long id){
		return baza.get(id);
	}
	
	public void save(Faktura faktura){
		if(faktura.getId() == null){
			faktura.setId(idGenerator.incrementAndGet());
		}
		baza.put(faktura.getId(), faktura);
	}

}
