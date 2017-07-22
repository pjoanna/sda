package oop;

/**
 * Created by RENT on 2017-07-12.
 */
public class Person1 {
    private String name;
    private String surname;
    private int age;

    public Person1(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        System.out.println("Przesłonięte :P");
        return "Jestem "+getName()+" "+getSurname()+" i mam "+getAge()+" lat";
    }
}
