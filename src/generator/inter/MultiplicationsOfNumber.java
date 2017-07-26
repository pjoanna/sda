package generator.inter;

/**
 * Created by RENT on 2017-07-22.
 */
public class MultiplicationsOfNumber implements Generator<Integer> { //kolejne wielokrotności liczby podanej w konstruktorze
    private final int number;
    private int value = 0;

    public MultiplicationsOfNumber(int step) {
        this.number = step;
    }

    public Integer generate(){
        value += number;
        return value;
    }

    public static void main(String[] args) {
        MultiplicationsOfNumber generator = new MultiplicationsOfNumber(5);
        GeneratorMethods.printTenElements(generator);

    }
}
