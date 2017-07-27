package mutability.builder;

/**
 * Created by RENT on 2017-07-22.
 */
public class PersonBuilder {

    private String name;
    private String surname;

    public PersonBuilder withName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder withSurame(String surname) {
        this.surname = surname;
        return this;
    }

    public Person build(){
        return new Person(name,surname);
    }
}
