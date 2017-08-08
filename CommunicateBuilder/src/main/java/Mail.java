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

    private Mail(String tresc, String nadawca, String nazwaSerweraPosredniego, String nazwaSkrzynkiPocztowej, String protokolKomunikacji, LocalDate dataNadania, LocalDate dataOdbioru, long adresIPNadania, long adresIPOdbiorcy, MESSAGE_TYPE message_type, boolean isSzyfrowane, boolean isSpam) {
        this.tresc = tresc;
        this.nadawca = nadawca;
        this.nazwaSerweraPosredniego = nazwaSerweraPosredniego;
        this.nazwaSkrzynkiPocztowej = nazwaSkrzynkiPocztowej;
        this.protokolKomunikacji = protokolKomunikacji;
        this.dataNadania = dataNadania;
        this.dataOdbioru = dataOdbioru;
        this.adresIPNadania = adresIPNadania;
        this.adresIPOdbiorcy = adresIPOdbiorcy;
        this.message_type = message_type;
        this.isSzyfrowane = isSzyfrowane;
        this.isSpam = isSpam;
    }
    public static class Builder{
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
            return new Mail(tresc, nadawca, nazwaSerweraPosredniego, nazwaSkrzynkiPocztowej, protokolKomunikacji, dataNadania, dataOdbioru, adresIPNadania, adresIPOdbiorcy, message_type, isSzyfrowane, isSpam);
        }
    }

}
