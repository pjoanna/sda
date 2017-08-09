import java.time.LocalDate;

/**
 * Created by RENT on 2017-08-08.
 */
public class Mail {
    private String tresc, nadawca, nazwaSerweraPosredniego, nazwaSkrzynkiPocztowej, protokolKomunikacji;
    private LocalDate dataNadania, dataOdbioru;
    private long adresIPNadania, adresIPOdbiorcy;
    private MESSAGE_TYPE message_type;
    private boolean isSzyfrowane, isSpam;

    public Mail(Builder builder) {
        this.tresc = builder.tresc;
        this.nadawca = builder.nadawca;
        this.nazwaSerweraPosredniego = builder.nazwaSerweraPosredniego;
        this.nazwaSkrzynkiPocztowej = builder.nazwaSkrzynkiPocztowej;
        this.protokolKomunikacji = builder.protokolKomunikacji;
        this.dataNadania = builder.dataNadania;
        this.dataOdbioru = builder.dataOdbioru;
        this.adresIPNadania = builder.adresIPNadania;
        this.adresIPOdbiorcy = builder.adresIPOdbiorcy;
        this.message_type = builder.message_type;
        this.isSzyfrowane = builder.isSzyfrowane;
        this.isSpam = builder.isSpam;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public String getNadawca() {
        return nadawca;
    }

    public void setNadawca(String nadawca) {
        this.nadawca = nadawca;
    }

    public String getNazwaSerweraPosredniego() {
        return nazwaSerweraPosredniego;
    }

    public void setNazwaSerweraPosredniego(String nazwaSerweraPosredniego) {
        this.nazwaSerweraPosredniego = nazwaSerweraPosredniego;
    }

    public String getNazwaSkrzynkiPocztowej() {
        return nazwaSkrzynkiPocztowej;
    }

    public void setNazwaSkrzynkiPocztowej(String nazwaSkrzynkiPocztowej) {
        this.nazwaSkrzynkiPocztowej = nazwaSkrzynkiPocztowej;
    }

    public String getProtokolKomunikacji() {
        return protokolKomunikacji;
    }

    public void setProtokolKomunikacji(String protokolKomunikacji) {
        this.protokolKomunikacji = protokolKomunikacji;
    }

    public LocalDate getDataNadania() {
        return dataNadania;
    }

    public void setDataNadania(LocalDate dataNadania) {
        this.dataNadania = dataNadania;
    }

    public LocalDate getDataOdbioru() {
        return dataOdbioru;
    }

    public void setDataOdbioru(LocalDate dataOdbioru) {
        this.dataOdbioru = dataOdbioru;
    }

    public long getAdresIPNadania() {
        return adresIPNadania;
    }

    public void setAdresIPNadania(long adresIPNadania) {
        this.adresIPNadania = adresIPNadania;
    }

    public long getAdresIPOdbiorcy() {
        return adresIPOdbiorcy;
    }

    public void setAdresIPOdbiorcy(long adresIPOdbiorcy) {
        this.adresIPOdbiorcy = adresIPOdbiorcy;
    }

    public MESSAGE_TYPE getMessage_type() {
        return message_type;
    }

    public void setMessage_type(MESSAGE_TYPE message_type) {
        this.message_type = message_type;
    }

    public boolean isSzyfrowane() {
        return isSzyfrowane;
    }

    public void setSzyfrowane(boolean szyfrowane) {
        isSzyfrowane = szyfrowane;
    }

    public boolean isSpam() {
        return isSpam;
    }

    public void setSpam(boolean spam) {
        isSpam = spam;
    }


    public static class Builder {
        private String tresc;
        private String nadawca;
        private String nazwaSerweraPosredniego;
        private String nazwaSkrzynkiPocztowej;
        private String protokolKomunikacji;
        private LocalDate dataNadania;
        private LocalDate dataOdbioru;
        private long adresIPNadania;
        private long adresIPOdbiorcy;
        private MESSAGE_TYPE message_type;
        private boolean isSzyfrowane;
        private boolean isSpam;

        public Builder() {

        }

        public Builder setTresc(String tresc) {
            this.tresc = tresc;
            return this;
        }

        public Builder setNadawca(String nadawca) {
            this.nadawca = nadawca;
            return this;
        }

        public Builder setNazwaSerweraPosredniego(String nazwaSerweraPosredniego) {
            this.nazwaSerweraPosredniego = nazwaSerweraPosredniego;
            return this;
        }

        public Builder setNazwaSkrzynkiPocztowej(String nazwaSkrzynkiPocztowej) {
            this.nazwaSkrzynkiPocztowej = nazwaSkrzynkiPocztowej;
            return this;
        }

        public Builder setProtokolKomunikacji(String protokolKomunikacji) {
            this.protokolKomunikacji = protokolKomunikacji;
            return this;
        }

        public Builder setDataNadania(LocalDate dataNadania) {
            this.dataNadania = dataNadania;
            return this;
        }

        public Builder setDataOdbioru(LocalDate dataOdbioru) {
            this.dataOdbioru = dataOdbioru;
            return this;
        }

        public Builder setAdresIPNadania(long adresIPNadania) {
            this.adresIPNadania = adresIPNadania;
            return this;
        }

        public Builder setAdresIPOdbiorcy(long adresIPOdbiorcy) {
            this.adresIPOdbiorcy = adresIPOdbiorcy;
            return this;
        }

        public Builder setMessage_type(MESSAGE_TYPE message_type) {
            this.message_type = message_type;
            return this;
        }

        public Builder setIsSzyfrowane(boolean isSzyfrowane) {
            this.isSzyfrowane = isSzyfrowane;
            return this;
        }

        public Builder setIsSpam(boolean isSpam) {
            this.isSpam = isSpam;
            return this;
        }

        public Mail createMail() {
            return new Mail(this);
        }
    }

}
