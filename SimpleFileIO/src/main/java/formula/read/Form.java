package main.java.formula.read;

/**
 * Created by RENT on 2017-08-02.
 */
public class Form {
    private String imie;
    private int wiek;
    private String plec;
    private String odp1;
    private String odp2;
    private String odp3;

    public Form() {
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getOdp1() {
        return odp1;
    }

    public void setOdp1(String odp1) {
        this.odp1 = odp1;
    }

    public String getOdp2() {
        return odp2;
    }

    public void setOdp2(String odp2) {
        this.odp2 = odp2;
    }

    public String getOdp3() {
        return odp3;
    }

    public void setOdp3(String odp3) {
        this.odp3 = odp3;
    }

    @Override
    public String toString() {
        return "Form{" + "\'\n" +
                "imie='" + imie + "\'\n" +
                ", wiek=" + wiek + "\'\n" +
                ", plec='" + plec + "\'\n" +
                ", odp1='" + odp1 + "\'\n" +
                ", odp2='" + odp2 + "\'\n" +
                ", odp3='" + odp3 + "\'\n" +
                "} \n\n";
    }
}
