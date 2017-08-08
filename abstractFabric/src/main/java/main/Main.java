package main;

import car.CarFactory;
import car.ICar;

/**
 * Created by RENT on 2017-08-08.
 */
public class Main {
    public static void main(String[] args) {
        ICar c = CarFactory.createBMW16();
        ICar car = CarFactory.createAudi();

    }
}
