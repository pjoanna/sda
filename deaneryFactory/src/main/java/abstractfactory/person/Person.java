package abstractfactory.person;

/**
 * Created by RENT on 2017-08-09.
 */
public class Person {
    private String name;
    private String surname;
    private Long index;

    public Person(String name, String surname, Long index) {
        this.name = name;
        this.surname = surname;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Student: " + getName()+ " " + getSurname();
    }
}
