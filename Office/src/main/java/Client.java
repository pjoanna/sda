import java.time.LocalDateTime;

/**
 * Created by pjoanna on 2017-08-08.
 */
public class Client {
    private Business business;
    private Long pesel;

    public Client(Long pesel, Business business) {
        this.pesel = pesel;
        this.business = business;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }
}
