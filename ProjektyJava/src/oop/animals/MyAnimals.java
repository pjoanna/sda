package oop.animals;

/**
 * Created by RENT on 2017-07-13.
 */
public class MyAnimals {
    private Animal cat = new Cat("Bob");
    private Animal dog = new Dog("Reksio");
    private Animal parrot = new Parrot("Papużka","Powtarzam po kazdym");


    private void introduce() {
        Animal[] animals = {cat, dog, parrot};
        for (Animal animal : animals) {
            animal.introduce();
            animal.sound();
        }
    }

    public static void main(String[] args) {
        MyAnimals animals = new MyAnimals();
        animals.introduce();
    }
}
