/**
 * Created by RENT on 2017-08-05.
 */
public enum CarType {
    TRACK(1.3), CAR(0.7), MOTORCYCLE(0.5);
    private double price;

    CarType(double mul) {
        price = mul;
    }

    public double getPrice() {
        return price;
    }

}
