package instrument;

/**
 * Created by RENT on 2017-07-13.
 */
public class Violin extends Instrument{
    public Violin(String name) {
        super(name, true);
    }

    @Override
    public void introduce() {
        System.out.println("Jestem skrzypce");

    }

    @Override
    public void play() {
        System.out.println("Gram jak skrzypce");
    }
}
