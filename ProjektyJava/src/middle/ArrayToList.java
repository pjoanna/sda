package middle;

import java.util.*;

/**
 * Created by RENT on 2017-07-11.
 */
public class ArrayToList {
    public static void main(String[] args) {
        List<String> list;
        String[] words = {"abc","def","ghi","jkl","mno","pqr"};
        list = toList(words);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static List<String> toList(String[] tab){
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < tab.length; i++) {
            list.add(tab[i]);
        }
        return list;

    }
}
