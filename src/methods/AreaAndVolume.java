package methods;

/**
 * Created by RENT on 2017-07-11.
 */
public class AreaAndVolume {

    public static void main(String[] args) {

    }

    public static double squareArea(double a){
        return a*a;
    }
    public static double cubeArea(double a){
        return 6*squareArea(a);
    }
    public static double circleArea(double r){
        return Math.PI*r*r;
    }

    public static double cylinderVolume(double r, double h){
        return h*circleArea(r);
    }

    public static double coneVolume(double r, double h){
        return cylinderVolume(r,h)/3;
    }
    public static double cubeVolume (double a){
        return a*squareArea(a);
    }
    public static double pyramidVolume(double a, double h){
        return squareArea(a)*h/3;
    }

}
