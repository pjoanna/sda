package parse.arrayT;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-07-27.
 */
public class MyParseArrayT{

    public static <T> List<T> parseListT(String text, ElementParser<T> parser)  {
        List<T> tList = new ArrayList<>();
        String[] tTextToArray;

        tTextToArray = text.split(",");

        for (String string : tTextToArray) {
            T element = parser.parse(string);
            tList.add(element);
        }

        return tList;
    }

    public static void main(String[] args) {
        ElementParser<Integer> number = new ElementParser<Integer>() {
            @Override
            public Integer parse(String element) throws IllegalArgumentException {
                Integer number = Integer.parseInt(element);
                return number;
            }
        };
        String text = "112748";
        System.out.println("Tekst przed parsowaniem " + text);
        parseListT(text, number);
        System.out.println("Tekst po parsowaniu " + parseListT(text, number));
    }

}
