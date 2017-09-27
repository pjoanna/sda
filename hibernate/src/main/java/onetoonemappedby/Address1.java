package onetoonemappedby;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by RENT on 2017-09-27.
 */
@Entity
@Table(name = "adres")
public class Address1 implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;
    private String city;
    private String state;

    @OneToOne(mappedBy = "address1")
    private Customer1 customer1;

    public Address1() {
    }

    public Address1(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public Customer1 getCustomer1() {
        return customer1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer1(Customer1 customer1) {
        this.customer1 = customer1;
    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address1{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", customer1=" + customer1 +
                '}';
    }
}
