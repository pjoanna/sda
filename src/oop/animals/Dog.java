package oop.animals;

/**
 * Created by RENT on 2017-07-13.
 */
public class Dog extends Animal {

    public Dog(String name) {
        super(name, false);
    }

    @Override
    public void sound() {
        System.out.println("Hau! Hau!");
    }

    @Override
    public void introduce() {
        System.out.println("Jestem psem "+getName());
    }
}
