import java.util.Observer;

/**
 * Created by pjoanna on 2017-08-13.
 */
public abstract class Person implements Observer{
    private String name;
    private String surname;
    private PersonType personType;

    public Person(String name, String surname, PersonType personType) {
        this.name = name;
        this.surname = surname;
        this.personType = personType;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public PersonType getPersonType() {
        return personType;
    }


}
