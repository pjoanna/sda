package sda.spring.faktury;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeneratorFaktur {
    @Autowired
    private GeneratorPozycjiFaktur generatorPozycjiFaktur;

    @Autowired
    private DodawaczDoFaktury dodawaczDoFaktury;

    @Autowired
    private SumatorFaktury sumatorFaktury;

    public Faktura generujFakture() {
        Faktura faktura = dodawaczDoFaktury.dodajDoFaktury(generatorPozycjiFaktur.stworz(), null);
        int liczbaPozycji = Double.valueOf(Math.random() * 50).intValue();
        for (int i = 0; i < liczbaPozycji; i++) {
            faktura= dodawaczDoFaktury.dodajDoFaktury(generatorPozycjiFaktur.stworz(), faktura.getId());

        }
        sumatorFaktury.podsumujFakture(faktura.getId());
        return faktura;

    }
}
