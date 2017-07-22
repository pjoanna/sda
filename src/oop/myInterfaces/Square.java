package oop.myInterfaces;

/**
 * Created by RENT on 2017-07-13.
 */
public class Square implements Figure{
    private double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public double countArea(){
        return a*a;
    }
    @Override
    public double countCircumference(){
        return 4*a;
    }
}
