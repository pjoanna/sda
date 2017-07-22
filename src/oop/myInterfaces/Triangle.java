package oop.myInterfaces;

/**
 * Created by RENT on 2017-07-13.
 */
public class Triangle implements Figure{
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public double countCircumference(){
        return a+b+c;
    }

    @Override
    public double countArea(){
        double p = countCircumference()/2;
        double result = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return result;

    }

}
