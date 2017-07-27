package collection.sets;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by RENT on 2017-07-17.
 */
public class Zad3Set {
    public static void main(String[] args) {
        Set<PairOfNumbers> pairOfNumbers = new HashSet<>();

        pairOfNumbers.add(new PairOfNumbers(1,2));
        pairOfNumbers.add(new PairOfNumbers(2,1));
        pairOfNumbers.add(new PairOfNumbers(1,1));
        pairOfNumbers.add(new PairOfNumbers(1,2));

        for (PairOfNumbers pairOfNumber : pairOfNumbers) {
            System.out.println(pairOfNumber.toString());
            // dodaje niby dwa takie same elementy
            // ale to dwa różne miejsca w pamięci
            // więc java widzi je jako coś innego
            // dlatego najpierw przed dodaniem należy
            // sprawdzić czy podobny obiekt juz tam jest
            // w tym celu nadpisujemy metody hashcode() i equals()
        }

    }
}
