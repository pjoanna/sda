package generator.inter;

/**
 * Created by RENT on 2017-07-24.
 */
public class GeneratorMethods {

    public static void printTenElements(Generator generator){

        Object data = generator.generate();
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.generate());
        }
    }

    public static void printEverySecondElement(Generator generator){
        Object data = generator.generate();
        for (int i = 0; i < 10; i++) {
            generator.generate();
            System.out.println(generator.generate());
        }

    }

    public static Integer sumOfElements (Generator<Integer> generator){
        Integer sum = 0;
        Integer generated = generator.generate();
        for (int i = 0; i < 10 ; i++) {
            if (generated != null){
                sum += generated.intValue();
            }else {
                break;
            }
        }
        return sum;
    }

}
