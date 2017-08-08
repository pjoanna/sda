package bike;

/**
 * Created by RENT on 2017-08-08.
 */
class Bike extends BikeFactory{
    private String brand;
    private int seats;
    private int gears; // przerzutki
    private BIKETYPE biketype;

    public Bike(String brand, int seats, int gears, BIKETYPE biketype) {
        this.brand = brand;
        this.seats = seats;
        this.gears = gears;
        this.biketype = biketype;
    }


}
