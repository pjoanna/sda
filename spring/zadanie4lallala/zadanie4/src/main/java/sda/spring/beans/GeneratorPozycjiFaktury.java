package sda.spring.beans;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class GeneratorPozycjiFaktury {
	
	public PozycjaFaktury stworz(){
		PozycjaFaktury pozycja = new PozycjaFaktury();
		pozycja.setCena(new BigDecimal("10"));
		pozycja.setOpis(UUID.randomUUID().toString());
		return pozycja;
	}

}
