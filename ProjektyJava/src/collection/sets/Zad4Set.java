package collection.sets;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by RENT on 2017-07-17.
 */
public class Zad4Set {

    public static Set<Double> varargs(double[] numbers) {
        Set<Double> doubleSet = new HashSet<>();
        for (double number : numbers) {
            try {
                if(doubleSet.contains(number)){
                    throw new IllegalArgumentException();
                }
                doubleSet.add(number);
            }catch (IllegalArgumentException e){
                System.out.println("Powtórzenie! Nie dodam elementu "+number);
            }
        }
        return doubleSet;
    }
    public static void main(String[] args) {
        double[] numbers = {5.0,9.0,3.0,7.0,2.0,9.0};
        Set<Double> doubles = new HashSet<>();
        varargs(numbers);


    }
}
