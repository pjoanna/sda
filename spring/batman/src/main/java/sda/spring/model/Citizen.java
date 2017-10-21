package sda.spring.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "citizens")
    private List<SuperHero> heroes = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Citizen citizen = (Citizen) o;

        if (id != null ? !id.equals(citizen.id) : citizen.id != null) return false;
        if (name != null ? !name.equals(citizen.name) : citizen.name != null) return false;
        return heroes != null ? heroes.equals(citizen.heroes) : citizen.heroes == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (heroes != null ? heroes.hashCode() : 0);
        return result;
    }

    public List<SuperHero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<SuperHero> heroes) {
        this.heroes = heroes;
    }
}
