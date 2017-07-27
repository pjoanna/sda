package parse.array;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

/**
 * Created by RENT on 2017-07-27.
 */
public class MyParseArray {
    public static List<Integer> parseList(String array) {
        String[] numbersHelp;
        if ((!array.startsWith("[") || !array.endsWith("]"))){
            throw new IllegalArgumentException("Podany format nie jest zgodny z oczekiwanym");
        }
        numbersHelp = array.replace(" ", "").replace("[","").replace("]","").split(",");

        List<Integer> numbers = new ArrayList<>();

        for (String numb : numbersHelp) {
            Integer number = Integer.parseInt(numb);
            numbers.add(number);
        }
        return numbers;
    }


}
