package generator.inter;

/**
 * Created by RENT on 2017-07-22.
 */
public class ArithmeticSequenceGenerator implements Generator <Integer>{
    private int value;
    private final int a1;
    private final int step;
    private int counter = 0;

    public ArithmeticSequenceGenerator(int a1, int step) {
        this.a1 = a1;
        this.step = step;
        this.value = a1;
    }

    public Integer generate(){
        value = a1 + counter * step;
        counter++;
        return value;
    }

    public static void main(String[] args) {
        ArithmeticSequenceGenerator generator = new ArithmeticSequenceGenerator(1,3);

      //  GeneratorMethods.printTenElements(generator);

    }
}
