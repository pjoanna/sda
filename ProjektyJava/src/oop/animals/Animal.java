package oop.animals;

/**
 * Created by RENT on 2017-07-13.
 */
public abstract class Animal {
    private String name;
    private boolean speak;

    public Animal(String name, boolean speak) {
        this.name = name;
        this.speak = speak;
    }

    public String getName() {
        return name;
    }

    public abstract void sound();
    public abstract void introduce();

}
