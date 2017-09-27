package onetoonemappedby;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by RENT on 2017-09-27.
 */
@Entity
@Table(name = "klient")
public class Customer1 implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String lastName;
    private String firstName;
    private int hasGoodCredit;

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address1 address1;

    public Customer1() {
    }

    public Customer1(String lastName, String firstName, int hasGoodCredit, Address1 address1) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.hasGoodCredit = hasGoodCredit;
        this.address1 = address1;
    }

    public void setId(int id) {
        this.id = id;
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

    public Address1 getAddress1() {
        return address1;
    }

    public void setAddress1(Address1 address1) {
        this.address1 = address1;
    }

    @Override
    public String toString() {
        return "Customer1{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", hasGoodCredit=" + hasGoodCredit +
                ", address1=" + address1 +
                '}';
    }
}
