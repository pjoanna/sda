package oop.myInterfaces;

/**
 * Created by RENT on 2017-07-13.
 */
public class Circle implements Figure{
    private double r;

    public Circle(double r) {
        this.r = r;
    }
    @Override
    public double countArea(){
        return r*r*Math.PI;

    }
    @Override
    public double countCircumference(){
        return 2*r*Math.PI;

    }


}
