package strategy;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class Main {

    public static void main(String[] args) {
        print(new FiveGenerateStrategy());
    }

    private static void print(GenerateStategy stategy) {
        for (int i = 0; i < 10; i++) {
            System.out.println(stategy.generate());
        }
    }
}
