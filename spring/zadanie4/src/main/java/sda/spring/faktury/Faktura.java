package sda.spring.faktury;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Faktura {
    private Long id;
    private List<PozycjaFaktury> pozycje = new ArrayList<>();
    private BigDecimal suma;

    public List<PozycjaFaktury> getPozycje() {
        return pozycje;
    }
    public BigDecimal getSuma() {
        return suma;
    }

    public void setSuma(BigDecimal suma) {
        this.suma = suma;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Faktura{" +
                "id=" + id +
                ", pozycje=" + pozycje +
                ", suma=" + suma +
                '}';
    }
}
