package instrument;

/**
 * Created by RENT on 2017-07-13.
 */
public class Keyboard extends Instrument{
    private int keys;
    public Keyboard(String name, int keys) {
        super(name, false);
        this.keys = keys;
    }

    public int getKeys() {
        return keys;
    }

    @Override
    public void introduce() {
        System.out.println("Jestem pianino");

    }

    @Override
    public void play() {
        System.out.println("Gram jak pianino");

    }
}
