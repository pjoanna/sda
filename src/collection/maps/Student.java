package collection.maps;

/**
 * Created by RENT on 2017-07-17.
 */
public class Student {
    private long indexNumber;
    private String name;
    private String surname;

    public Student(long indexNumber, String name, String surname) {
        this.indexNumber = indexNumber;
        this.name = name;
        this.surname = surname;
    }

    public long getIndexNumber() {
        return indexNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student o indeksie "+getIndexNumber()+" to "+getName()+" "+getSurname();
    }
}
