package sda.nordea.hello;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String surname;
    private int age;
    private boolean adult;

    public User() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public boolean isAdult(){
      return age >= 18;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", adult=" + adult +
                '}';
    }
}
