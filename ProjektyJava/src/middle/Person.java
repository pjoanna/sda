package middle;

/**
 * Created by RENT on 2017-07-12.
 */
public class Person {
    private String name;
    private String surname;

    public static void main(String[] args) {
        Person person = createPerson("abc","P");
        System.out.println(person.name+" "+person.surname);

    }
    public static Person createPerson(String name, String surname){
        Person person = new Person();
        person.name = name;
        person.surname = surname;
        return person;
    }

}
