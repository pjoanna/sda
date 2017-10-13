package sda.spring.faktury;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DodawaczDoFaktury {

    @Autowired
    private Database baza;

    public Faktura dodajDoFaktury(PozycjaFaktury pozycjaFaktury, Long idFaktury) {
        Faktura faktura = baza.findById(idFaktury);

        if (faktura == null) {
            faktura = new Faktura();
        }

        faktura.getPozycje().add(pozycjaFaktury);
        baza.save(faktura);
        return faktura;
    }
}
