package collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-07-15.
 */
public class ListExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for (Integer integer : list){
            System.out.println(integer);
        }
        list.remove((Object) 2);

        for (Integer integer : list){
            System.out.println(integer);
        }

        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");

        System.out.println("znaki: ");
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();


        strings.remove(1);

        System.out.println("znaki: ");
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();

        strings.remove("d");

        System.out.println("znaki: ");
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();

        System.out.println("Size: "+strings.size());
        System.out.println("Index of: "+strings.indexOf("c"));
        System.out.println("contains a : "+strings.contains("a"));
        System.out.println("contains b : "+strings.contains("b"));
        System.out.println("element 1 : "+strings.get(1));
    }
}
