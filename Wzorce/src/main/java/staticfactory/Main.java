package staticfactory;

import abstractfactory.AbstractWordsFactory;
import abstractfactory.PlusWordsFactory;

/**
 * Created by pjoanna on 2017-08-21.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(StaticFactory.newFixedLengthStarWord(6));
        System.out.println(StaticFactory.newFixedLengthStarWord(3));
        System.out.println(StaticFactory.newFixedLengthStarWord(9));
        System.out.println(StaticFactory.newFixedLengthStarWord(12));
    }
}
