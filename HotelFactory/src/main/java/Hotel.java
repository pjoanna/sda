import java.util.List;

/**
 * Created by RENT on 2017-08-09.
 */
public class Hotel {
    private final HotelPhone phone = new HotelPhone();
    private List<HotelEmployee> employees;
    private List<HotelRoom> rooms;

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

    public void complain(){

    }

    public void checkCalls(){
        for (PhoneCall call : phone.getCalls()) {
            System.out.println(call.toString());
        }

    }
}
