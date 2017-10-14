package sda.spring.beans;

import java.math.BigDecimal;

public class PozycjaFaktury {
	
	private String opis;
	private BigDecimal cena;
	
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public BigDecimal getCena() {
		return cena;
	}
	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}
	@Override
	public String toString() {
		return "PozycjaFaktury [opis=" + opis + ", cena=" + cena + "]";
	}
	

}
