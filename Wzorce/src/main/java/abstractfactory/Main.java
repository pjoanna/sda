package abstractfactory;

/**
 * Created by pjoanna on 2017-08-21.
 */
public class Main {

    public static void main(String[] args) {
        AbstractWordsFactory factory = new PlusWordsFactory();
        System.out.println(factory.newFixedLengthWord(6));
        System.out.println(factory.newFixedLengthWord(3));
        System.out.println(factory.newFixedLengthWord(9));
        System.out.println(factory.newFixedLengthWord(12));
    }
}
