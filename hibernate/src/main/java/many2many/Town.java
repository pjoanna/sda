package many2many;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by RENT on 2017-09-28.
 */
@Entity
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String country;

    @ManyToMany
    @JoinTable(name = "town_to_attraction",
            joinColumns = {@JoinColumn(name = "town_id")},
            inverseJoinColumns = {@JoinColumn(name = "attraction_id")}
    )
    private Set<Attraction> attractions = new HashSet<>();

    public Town() {
    }

    public Town(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(Set<Attraction> attractions) {
        this.attractions = attractions;
    }

    @Override
    public String toString() {
        return "Town{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", attractions=" + attractions +
                '}';
    }
}
