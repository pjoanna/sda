/**
 * Created by pjoanna on 2017-08-08.
 */
public class Client {
    private Business business;
    private long pesel;

    public Client(Business business, long pesel) {
        this.business = business;
        this.pesel = pesel;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }
}
