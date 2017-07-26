package generator.inter;

import java.util.Random;

/**
 * Created by RENT on 2017-07-22.
 */
public class RandomNumbersFromIntervalGenerator implements Generator<Integer> {

    private final Random random = new Random();
    private int start;
    private int end;
    private int interval;

    public RandomNumbersFromIntervalGenerator(int start, int end) {
        this.start = start;
        this.end = end;
        this.interval = end - start + 1;
    }

    public Integer generate(){
        int value = random.nextInt(interval) + start;
        return value;
    }

    public static void main(String[] args) {

        RandomNumbersFromIntervalGenerator generator = new RandomNumbersFromIntervalGenerator(13,18);
        GeneratorMethods.printTenElements(generator);

    }
}
