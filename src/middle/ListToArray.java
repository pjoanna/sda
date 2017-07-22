package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-07-11.
 */
public class ListToArray {
    public static void main(String[] args) {
        String[] myArray;
        List<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("jkl");
        myArray = toArray(list);

        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }

    }
    public static String[] toArray(List<String> list){
        String[] newWords = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            newWords[i] = list.get(i);
        }

        return newWords;
    }
}
