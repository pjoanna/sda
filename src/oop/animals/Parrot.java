package oop.animals;

/**
 * Created by RENT on 2017-07-13.
 */
public class Parrot extends Animal{
    private String word;

    public Parrot(String name, String word) {
        super(name, true);
        this.word = word;
    }

    @Override
    public void sound() {
        System.out.println("Cześć! Potrafię powiedzieć, co tylko zechcę");
    }

    @Override
    public void introduce() {
        System.out.println("Jestem papugą "+getName());

    }
}
