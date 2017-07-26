package generator.inter;

/**
 * Created by RENT on 2017-07-22.
 */
public class SequenceGenerator implements Generator<Integer> {
    private int counter = 1;

    public Integer generate(){
       // return counter++;     // kolejnych liczb
        return 2*(counter++);   // kolejnych liczb parzystych
    }

    public static void main(String[] args) {
        SequenceGenerator generator = new SequenceGenerator();
        GeneratorMethods.printTenElements(generator);



    }
}
