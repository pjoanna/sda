package parse.arrayT;

import java.text.ParseException;

/**
 * Created by RENT on 2017-07-27.
 */
public interface ElementParser<T> {

    T parse(String element) throws IllegalArgumentException;

}
