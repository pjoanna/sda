/**
 * Created by pjoanna on 2017-08-09.
 */
public class Student {
    private Long pesel;
    private String name;
    private String surname;

    public Student(Long pesel, String name, String surname) {
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
    }

    public Long getPesel() {
        return pesel;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Uczeń: " + getName() + " " + getSurname();
    }
}
