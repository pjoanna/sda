package onetomany;

import onetoone.Address;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by RENT on 2017-09-27.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String login;

    @OneToMany(fetch = FetchType.EAGER) // zachłanny - zawsze joinuje w zapytaniach tabele, LAZY - joinuje gdy jest join w zapytaniu
    @JoinColumn(name = "USER_ID")
    private Collection<Phone> phones = new ArrayList<>();

    public User() {
    }

    public User(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Collection<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Collection<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", phones=" + phones +
                '}';
    }

}
