package generator;

/**
 * Created by RENT on 2017-07-22.
 */
public class FiveGenerator {
    public int generate(){
        return 5;

    }

    public static void main(String[] args) {

        FiveGenerator fiveGenerator = new FiveGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.println(fiveGenerator.generate());
        }
    }

}
