package sda.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DodawaczDoFaktury {
	
	@Autowired
	private BazaDanych baza;

	public Faktura dodajDoFaktury(PozycjaFaktury pozycja, Long idFaktury){
		Faktura faktura = baza.findById(idFaktury);
		if(faktura == null){
			faktura = new Faktura();
		}
		faktura.getPozycje().add(pozycja);
		baza.save(faktura);
		return faktura;
	}
}
