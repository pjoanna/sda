package singleton;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class ExampleSingleton {
    private static ExampleSingleton ourInstance = new ExampleSingleton();

    public static ExampleSingleton getInstance() {
        return ourInstance;
    }

    private ExampleSingleton() {
    }
}
