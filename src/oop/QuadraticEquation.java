package oop;

/**
 * Created by RENT on 2017-07-12.
 */
public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calcDelta(){
        double delta = b*b-4*a*c;
        return delta;
    }

    public double calcX1() {
        double x1;
        if(calcDelta()>0) {
            x1 = (-b - Math.sqrt(calcDelta())) / (2 * a);
            return x1;
        }
        throw new NegativDeltaException();
    }
    public double calcX2(){
        double x2;
        if(calcDelta()>0) {
            x2 = (-b + Math.sqrt(calcDelta())) / (2 * a);
            return x2;
        }
        throw new NegativDeltaException();
    }

    public static void main(String[] args) {
        QuadraticEquation equation = new QuadraticEquation(1,1,1);
        System.out.println("delta = "+equation.calcDelta());
        if (equation.calcDelta()>=0){
            System.out.println("x1 = " + equation.calcX1());
            System.out.println("x2 = " + equation.calcX2());
        }else {
            System.out.println("Miejsca zerowe w R nie istnieją");
        }

    }


}
