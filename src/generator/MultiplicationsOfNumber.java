package generator;

/**
 * Created by RENT on 2017-07-22.
 */
public class MultiplicationsOfNumber { //kolejne wielokrotności liczby podanej w konstruktorze
    private final int number;
    private int value = 0;

    public MultiplicationsOfNumber(int step) {
        this.number = step;
    }

    public int generate(){
        value += number;
        return value;
    }

    public static void main(String[] args) {
        MultiplicationsOfNumber generator = new MultiplicationsOfNumber(5);
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.generate());
        }

    }
}
