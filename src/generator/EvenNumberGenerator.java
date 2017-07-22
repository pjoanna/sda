package generator;

/**
 * Created by RENT on 2017-07-22.
 */
public class EvenNumberGenerator { // kolejne parzyste
    private int i;

    public EvenNumberGenerator(int i) {
        i=2;
    }

    public int generate(){
        int value = i;
        i+=2;
        return value;
    }

    public static void main(String[] args) {
        EvenNumberGenerator generator = new EvenNumberGenerator(5);
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.generate());
        }

    }
}
