package collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-07-15.
 */
public class ListGenerator {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        Integer[] myArray = {1, 32, 7, 65, 65, 75, 54, 32, 43, 7};
        myList.add(1);
        myList.add(32);
        myList.add(7);
        myList.add(23);
        myList.add(32);
        myList.add(23);
        myList.add(54);
        myList.add(43);
        myList.add(32);
        myList.add(7);

        int counter = 0;

        for (int i = 0; i < Integer.min(myArray.length, myList.size()); i++) {
            if (myArray[i] == myList.get(i)) {
                System.out.print(i + " ");
                counter++;
            }
        }
        System.out.println();

        System.out.println("Wynik = " + counter);

    }
}
