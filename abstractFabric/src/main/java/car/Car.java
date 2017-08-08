package car;

/**
 * Created by RENT on 2017-08-08.
 */
class Car implements ICar {
    private String manufacturer;
    private double gasLevel;
    private int topSpeed;
    private double horsepower;
    private int seats;

    public Car(String manufacturer, double gasLevel, int speed, int seats) {
        this.manufacturer = manufacturer;
        this.gasLevel = gasLevel;
        this.topSpeed = speed;
        this.seats = seats;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public double getGasLevel() {
        return gasLevel;
    }

    public void setGasLevel(double gasLevel) {
        this.gasLevel = gasLevel;
    }

    @Override
    public void drive() {
        System.out.println("Jade samochodem marki: " + manufacturer);
    }

    @Override
    public int getSpeed() {
        return topSpeed;
    }

    public void setSpeed(int speed) {
        this.topSpeed = speed;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(double horsepower) {
        this.horsepower = horsepower;
    }
}
