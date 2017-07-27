package parse.array;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-07-27.
 */
public class MyParseArrayT{

    public static <T> List<T> parseListT(String text, ElementParser<T> parser)  {
        List<T> tList = new ArrayList<>();
        String[] tHelp;
//        if ((!text.startsWith("[") || !text.endsWith("]"))){
//            throw new IllegalArgumentException("Podany format nie jest zgodny z oczekiwanym");
//        }
        tHelp = text.split(",");

        for (String s : tHelp) {
            T element = parser.parse(s);
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
        String text = "112,748";
        System.out.println("Tekst przed parsowaniem " + text);
        parseListT(text, number);
        System.out.println("Tekst po parsowaniu " +  parseListT(text, number));
    }

}
