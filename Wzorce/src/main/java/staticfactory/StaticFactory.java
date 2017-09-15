package staticfactory;

/**
 * Created by pjoanna on 2017-08-21.
 */
public final class StaticFactory {

    private StaticFactory(){}

    public static String newFixedLengthStarWord(int length) {
        String s = "";
        for (int i = 0; i < length; i++) {
            s += "*";
        }
        return s;
    }

    public static String newFixedLengthPlusWord(int length) {
        String s = "";
        for (int i = 0; i < length; i++) {
            s += "+";
        }
        return s;
    }
}
