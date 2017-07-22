package oop;

/**
 * Created by RENT on 2017-07-12.
 */
public class Person1Test {

    public static void main(String[] args) {
        Person1[] people = new Person1[3];
        people[0] = new Person1("Ania","Kowal",30);
        people[1] = new Person1( "Basia", "Kowal", 40);
        people[2] = new Person1("Daniel", "Kowal", 25);


        for (Person1 person : people){
            System.out.println(person.toString());
        }
    }
}
