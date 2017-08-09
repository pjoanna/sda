import java.util.List;

/**
 * Created by RENT on 2017-08-09.
 */
public class Hotel {
    private HotelPhone phone;
    private List<HotelEmployee> employees;
    private List<HotelRoom> rooms;

    public Hotel(HotelPhone phone) {
        this.phone = phone;
    }

    public void handleClient(HotelGuest guest){
        //?dla każdego klienta iteruje po kolekcji klientów
        // i przydziela kolejnego pracownika.
        // Jeśli pula została przekroczona,
        // przydzielany jest od nowa pracownik nr. 0.
        // (trzeba zrobić licznik w klasie,
        // który przy każdym handle się zwiększa,
        // a po przekroczeniu rozmiaru używamy modulo).
    }

    public void register(){


    }

    public void unregister(){

    }

    public void externalConnection(){

    }

    public void complaint(){

    }
}
