package oop.dataProviderInterface;

import java.util.Random;

/**
 * Created by RENT on 2017-07-15.
 */
public class RandomDataProvider implements DataProvider{
    Random generator = new Random();
    @Override
    public int nextInt(String name) {
        int value = generator.nextInt(130);
        return value;
    }

    @Override
    public String nextString(String name) {
        String[] values = {"name0", "name1", "name2", "name3", "name4", "name5"};
        String value = values[generator.nextInt(values.length)];
        return value;
    }
}
