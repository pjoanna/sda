package throwables;

/**
 * Created by RENT on 2017-07-15.
 */
public class Person {
    int age;
    String name;
    String surname;

    public Person(int age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }
}
