package instrument;

/**
 * Created by RENT on 2017-07-13.
 */
public class Harp extends Instrument{
    public Harp(String name) {
        super(name, true);
    }

    @Override
    public void introduce() {
        System.out.println("Jestem harfa");

    }

    @Override
    public void play() {
        System.out.println("Gram jak harfa");
    }
}
