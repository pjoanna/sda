package main.java;

import main.java.IHero;

/**
 * Created by RENT on 2017-08-16.
 */
public class HeroOnAHorse implements IHero {

    private Hero heroToDecorate;

    public HeroOnAHorse(Hero heroToDecorate) {
        this.heroToDecorate = heroToDecorate;
    }

    @Override
    public int getHealth() {
        return heroToDecorate.getHealth() + 200;
    }

    @Override
    public int getStamina() {
        return ((int) (heroToDecorate.getStamina() * 1.20));
    }

    @Override
    public int getDefencePoints() {
        return heroToDecorate.getDefencePoints() + 10;
    }

    @Override
    public int getAttackPoints() {
        return heroToDecorate.getAttackPoints() + 50;
    }

    @Override
    public String toString() {
        return "HeroOnAHorse{" +
                "heroToDecorate=" + heroToDecorate +
                '}';
    }
}
