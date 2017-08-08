package car;

/**
 * Created by RENT on 2017-08-08.
 */
public abstract class CarFactory {
    public static Car createBMW16(){
        return new Car("BMW", 30.0, 200, 4);
    }

    public static Car createAudi(){
        return new Car("Audi", 32.0, 201, 4);
    }
}
