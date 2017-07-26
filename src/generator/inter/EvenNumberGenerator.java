package generator.inter;

/**
 * Created by RENT on 2017-07-22.
 */
public class EvenNumberGenerator implements Generator<Integer>{ // kolejne parzyste
    private int i;

    public EvenNumberGenerator() {
        i=2;
    }

    public Integer generate(){
        int value = i;
        i+=2;
        return value;
    }

    public static void main(String[] args) {
        EvenNumberGenerator generator = new EvenNumberGenerator();
        GeneratorMethods.printTenElements(generator);

    }
}
