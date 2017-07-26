package generator.inter;

/**
 * Created by RENT on 2017-07-22.
 */
public class FiveGenerator implements Generator<Integer>{
    public Integer generate(){
        return 5;

    }

    public static void main(String[] args) {
        FiveGenerator fiveGenerator = new FiveGenerator();
        GeneratorMethods.printTenElements(fiveGenerator);
    }



}
