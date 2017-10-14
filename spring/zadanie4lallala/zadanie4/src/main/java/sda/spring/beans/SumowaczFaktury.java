package sda.spring.beans;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SumowaczFaktury {
	
	@Autowired
	private BazaDanych baza;
	
	public void podsumujFakture(Long idFaktury){
		Faktura faktura = baza.findById(idFaktury);
		if(faktura != null){
			BigDecimal suma = BigDecimal.ZERO;
			for (PozycjaFaktury pozycja : faktura.getPozycje()) {
				suma = suma.add(pozycja.getCena());
			}
			faktura.setSuma(suma);
			baza.save(faktura);
		}
	}

}
