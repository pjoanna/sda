package singleton;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class Main {
    public static void main(String[] args) {
        ExampleClass exampleClass = new ExampleClass("Any");
        String printed = exampleClass.toString();
        System.out.println(printed);
    }
}
