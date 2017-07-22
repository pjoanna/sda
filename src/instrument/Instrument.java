package instrument;

/**
 * Created by RENT on 2017-07-13.
 */
public abstract class Instrument {
    private String name;
    private boolean strings;

    public Instrument(String name, boolean strings) {
        this.name = name;
        this.strings = strings;
    }

    public String getName() {
        return name;
    }

    public boolean isStrings() {
        return strings;
    }

    public abstract void introduce();
    public abstract void play();
}
