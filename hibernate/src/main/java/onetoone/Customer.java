package onetoone;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by RENT on 2017-09-27.
 */
@Entity
public class Customer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String lastName;
    private String firstName;
    private int hasGoodCredit;

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    public Customer() {
    }

    public Customer(String lastName, String firstName, int hasGoodCredit, Address address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.hasGoodCredit = hasGoodCredit;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getHasGoodCredit() {
        return hasGoodCredit;
    }

    public void setHasGoodCredit(int hasGoodCredit) {
        this.hasGoodCredit = hasGoodCredit;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
