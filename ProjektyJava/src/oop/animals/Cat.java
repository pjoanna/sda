package oop.animals;

/**
 * Created by RENT on 2017-07-13.
 */
public class Cat extends Animal{
    public Cat(String name) {
        super(name, false);
    }

    @Override
    public void sound() {
        System.out.println("Miau!");
    }

    @Override
    public void introduce() {
        System.out.println("Jestem kotem "+getName());
    }
}
