package sda.spring.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SuperHero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "citizens_heroes",
            joinColumns = {@JoinColumn (name="hero_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "citizen_id", referencedColumnName = "id")})
    private List<Citizen> citizens = new ArrayList<>();

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SuperHero hero = (SuperHero) o;

        if (id != null ? !id.equals(hero.id) : hero.id != null) return false;
        if (name != null ? !name.equals(hero.name) : hero.name != null) return false;
        return citizens != null ? citizens.equals(hero.citizens) : hero.citizens == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (citizens != null ? citizens.hashCode() : 0);
        return result;
    }
}
