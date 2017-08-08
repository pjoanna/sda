package bike;

/**
 * Created by RENT on 2017-08-08.
 */
public abstract class BikeFactory {

    public static BikeFactory create1cross5(){
        return new Bike("Kross",1,5, BIKETYPE.BICYCLE);
    }
    public static BikeFactory create1merida6(){
        return new Bike("merida",1,6, BIKETYPE.BICYCLE);
    }
    public static BikeFactory create2iniana3(){
        return new Bike("iniana",2,3, BIKETYPE.TANDEM);
    }
    public static BikeFactory create1felt6(){
        return new Bike("Kross",1,6, BIKETYPE.BICYCLE);
    }
    public static BikeFactory create2goetze1(){
        return new Bike("goetze",2,1, BIKETYPE.TANDEM);
    }

}
