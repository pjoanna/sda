package sda.spring.faktury;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SumatorFaktury {
    @Autowired
    private Database baza;

    public void podsumujFakture(Long idFaktury){
        Faktura faktura = baza.findById(idFaktury);
        if (faktura != null){
            BigDecimal suma = BigDecimal.ZERO;
            for (PozycjaFaktury pozycjaFaktury : faktura.getPozycje()){
                suma = suma.add(pozycjaFaktury.getCena());
            }
            faktura.setSuma(suma);
            baza.save(faktura);
        }

    }
}
