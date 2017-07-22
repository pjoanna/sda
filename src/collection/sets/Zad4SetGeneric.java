package collection.sets;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by RENT on 2017-07-17.
 */
public class Zad4SetGeneric {

    public static <T> Set<T> newSet(T... data) {
        Set<T> tSet = new HashSet<T>();
        for (T t : data) {
                if(tSet.contains(t)){
                    throw new IllegalArgumentException("Powtórzenie: "+t);
                }
                tSet.add(t);
        }
        return tSet;
    }
    public static void main(String[] args) {
        Double[] data = {5.0,9.0,3.0,7.0,2.0,9.0};
        Set<Double> tSetDoubles = new HashSet<>();
        newSet(data);

        String[] words = {"a","b","c","d","e","a"};
        Set<String> tSetStrings = new HashSet<>();
        newSet(words);

        PairOfNumbers[] pairOfNumbers = {
                new PairOfNumbers(1,2),
                new PairOfNumbers(2,1),
                new PairOfNumbers(1,1),
                new PairOfNumbers(1,2)};
        newSet(pairOfNumbers);


    }
}
