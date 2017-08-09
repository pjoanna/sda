/**
 * Created by RENT on 2017-08-09.
 */
public class HotelGuest {
    private String name;
    private String surname;
    private Long idGuest;

    public HotelGuest(String name, String surname, Long idGuest) {
        this.name = name;
        this.surname = surname;
        this.idGuest = idGuest;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Long getIdGuest() {
        return idGuest;
    }
}
