import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by RENT on 2017-08-09.
 */
public class PhoneCall {
    private Long id;
    private HotelGuest guest;
    private HotelEmployee employee;
    private LocalDateTime time;
    private Duration durationTime;

    public PhoneCall(Long id, HotelGuest guest, HotelEmployee employee, LocalDateTime time, Duration durationTime) {
        this.id = id;
        this.guest = guest;
        this.employee = employee;
        this.time = time;
        this.durationTime = durationTime;
    }

    public Long getId() {
        return id;
    }

    public HotelGuest getGuest() {
        return guest;
    }

    public HotelEmployee getEmployee() {
        return employee;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Duration getDurationTime() {
        return durationTime;
    }

    @Override
    public String toString() {
        return "Pracownik "+ getEmployee().toString() + " rozmawiał z gościem " + getGuest().toString() +
                "o godzinie " + getTime().toString() + ". Czas trwania rozmowy: " + getDurationTime().toString();
    }
}
