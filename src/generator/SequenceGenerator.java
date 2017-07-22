package generator;

/**
 * Created by RENT on 2017-07-22.
 */
public class SequenceGenerator {
    private int counter = 1;

    public int generate(){
       // return counter++;     // kolejnych liczb
        return 2*(counter++);   // kolejnych liczb parzystych
    }

    public static void main(String[] args) {
        SequenceGenerator generator = new SequenceGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.generate());
        }

    }
}
