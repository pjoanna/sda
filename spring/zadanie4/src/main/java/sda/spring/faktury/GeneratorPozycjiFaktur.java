package sda.spring.faktury;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class GeneratorPozycjiFaktur {
    public PozycjaFaktury stworz(){
        PozycjaFaktury pozycjaFaktury = new PozycjaFaktury();
        pozycjaFaktury.setCena(BigDecimal.TEN);
        pozycjaFaktury.setOpis(UUID.randomUUID().toString());
        return pozycjaFaktury;
    }
}
