import java.time.LocalDateTime;

/**
 * Created by RENT on 2017-08-09.
 */
public class HotelEmployee {
    private String name;
    private String surname;
    private Long idEmployee;

    public HotelEmployee(String name, String surname, Long idEmployee) {
        this.name = name;
        this.surname = surname;
        this.idEmployee = idEmployee;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname();
    }
}
