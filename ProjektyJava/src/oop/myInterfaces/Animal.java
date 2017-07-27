package oop.myInterfaces;

/**
 * Created by RENT on 2017-07-13.
 */
public interface Animal {
    int NUMBER = 1; // z definicji jest finalna kazda zmienna w interfejsie wiec nie mozna zmienic jej wartosci
    void  makeNoise();
    default void doSomething(){}
}

//interfejsy mozna dziedziczyc
