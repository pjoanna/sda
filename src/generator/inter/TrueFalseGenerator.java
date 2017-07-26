package generator.inter;

/**
 * Created by RENT on 2017-07-22.
 */
public class TrueFalseGenerator implements Generator<Boolean>{
    private boolean value = false;

    public Boolean generate(){
        value = !value;
        return value;
    }

    public static void main(String[] args) {
        TrueFalseGenerator generator = new TrueFalseGenerator();
        GeneratorMethods.printTenElements(generator);

    }
}
