package cities.app;

/**
 * Created by RENT on 2017-07-29.
 */
public class SequenceGenerator {
    private long counter = 1;

    public long generate(){
         return counter++;
    }
}
