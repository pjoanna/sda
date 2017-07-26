package generator.inter;

/**
 * Created by RENT on 2017-07-22.
 */
public class GeometricSequenceGenerator implements Generator<Double>{
    private double value;
    private final int a1;
    private final int step;
    private int counter = 0;

    public GeometricSequenceGenerator(int a1, int step) {
        this.a1 = a1;
        this.step = step;
        this.value = a1;
    }

    public Double generate(){
        value = a1 * Math.pow(step, counter);
        counter++;
        return value;
    }

    public static void main(String[] args) {
        GeometricSequenceGenerator generator = new GeometricSequenceGenerator(1,2);
      //  GeneratorMethods.printTenElements(generator);
      //  GeneratorMethods.printEverySecondElement(generator);


    }
}
