package oop.myInterfaces;

/**
 * Created by RENT on 2017-07-13.
 */
public class AnimalsMain {
    public static void main(String[] args) {
        Animal[] animals = {new Cat(), new Dog()};

        for (Animal animal : animals) {
            animal.makeNoise();
        }

    }
}
