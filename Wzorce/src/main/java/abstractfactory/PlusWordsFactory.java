package abstractfactory;

/**
 * Created by pjoanna on 2017-08-21.
 */
public class PlusWordsFactory extends AbstractWordsFactory{
    @Override
    public String newFixedLengthWord(int length) {
        String s = "";
        for (int i = 0; i < length; i++) {
            s += "+";
        }
        return s;
    }
}
