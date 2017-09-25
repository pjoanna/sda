package pl.sdacademy.jdbc.animal;

/**
 * Created by RENT on 2017-09-25.
 */
public class Animal {
    private Long id;
    private String name;
    private String breed;
    private Long person_id;

    public Animal(Long id, String name, String breed, Long person_id) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.person_id = person_id;
    }
    public Animal(){

    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", person_id=" + person_id +
                '}';
    }

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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }
}
