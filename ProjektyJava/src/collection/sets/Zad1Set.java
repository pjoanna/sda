package collection.sets;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by RENT on 2017-07-17.
 */
public class Zad1Set {

    public static void main(String[] args) {
        int[] data = {10,12,10,3,4,12,12,3,12,4,5,300,55,40};
        Set<Integer> set = new HashSet<>();

        for(int i : data){
            set.add(i);
        }

        System.out.println("Rozmiar: "+set.size());
        for (Integer element : set) {
            System.out.println(element);
        }
        set.remove(10);
        set.remove(12);

        System.out.println("Rozmiar: "+set.size());
        for (Integer element : set) {
            System.out.println(element);
        }

        //// TreeSet !!!
        System.out.println("TreeSet");
        set = new TreeSet<>();
        for (int i = 0; i < data.length; i++) {
            set.add(data[i]);
        }
        System.out.println("Rozmiar: "+set.size());
        for (Integer element : set) {
            System.out.println(element);
        }
        set.remove(10);
        set.remove(12);

        System.out.println("Rozmiar: "+set.size());
        for (Integer element : set) {
            System.out.println(element);
        }



    }
}
