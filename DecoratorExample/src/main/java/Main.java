package main.java;

import main.java.Hero;
import main.java.HeroOnAHorse;

/**
 * Created by RENT on 2017-08-16.
 */
public class Main {
    public static void main(String[] args) {
        Hero newHero = new Hero("Zenek");
        System.out.println(newHero);

        HeroOnAHorse decorated = new HeroOnAHorse(newHero);
        System.out.println(decorated);

        System.out.println(newHero.getAttackPoints());
        System.out.println(decorated.getAttackPoints());
    }
}
