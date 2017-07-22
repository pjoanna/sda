package instrument;

/**
 * Created by RENT on 2017-07-13.
 */
public class Guitar extends Instrument{
    public Guitar(String name) {
        super(name, true);
    }

    @Override
    public void introduce() {
        System.out.println("Jestem gitara");

    }

    @Override
    public void play() {
        System.out.println("Gram jak gitara");
    }
}
