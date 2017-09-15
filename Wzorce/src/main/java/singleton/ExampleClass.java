package singleton;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class ExampleClass {
    private String name;
    private final ExampleSingleton singleton;

    public ExampleClass(String name) {
        this.name = name;
        this.singleton = ExampleSingleton.getInstance();
    }


    @Override
    public String toString() {
        return name + " " + singleton.toString();
    }
}
