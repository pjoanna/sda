package generator;

import java.util.Random;

/**
 * Created by RENT on 2017-07-22.
 */
public class RandomNumbersFromIntervalGenerator {

    private final Random random = new Random();
    private int start;
    private int end;
    private int interval;

    public RandomNumbersFromIntervalGenerator(int start, int end) {
        this.start = start;
        this.end = end;
        this.interval = end - start + 1;
    }

    public int generate(){
        int value = random.nextInt(interval) + start;
        return value;
    }

    public static void main(String[] args) {

        RandomNumbersFromIntervalGenerator generator = new RandomNumbersFromIntervalGenerator(13,18);
        for (int i = 0; i < 25; i++) {
            System.out.println(generator.generate());
        }

    }
}
