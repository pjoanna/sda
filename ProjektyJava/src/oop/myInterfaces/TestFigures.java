package oop.myInterfaces;

/**
 * Created by RENT on 2017-07-13.
 */
public class TestFigures {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3,4,5);
        Square square= new Square(4);
        Circle circle = new Circle(4);
        Figure[] figures = {triangle, circle, square};

        for (Figure figure : figures) {
            print(figure);
        }
    }

    public static void print(Figure figure){
        System.out.println(figure.countArea());
        System.out.println(figure.countCircumference());
    }
}
