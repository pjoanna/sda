package main.java;

import main.java.IHero;

/**
 * Created by RENT on 2017-08-16.
 */
public class Hero implements IHero {
    private int health;
    private int stamina;
    private String name;
    private int defencePoints;
    private int attackPoints;

    public Hero(String name) {
        this.name = name;
        this.health = 100;
        this.stamina = 100;
        this.defencePoints = 200;
        this.attackPoints = 200;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefencePoints() {
        return defencePoints;
    }

    public void setDefencePoints(int defencePoints) {
        this.defencePoints = defencePoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "health=" + health +
                ", stamina=" + stamina +
                ", name='" + name + '\'' +
                ", defencePoints=" + defencePoints +
                ", attackPoints=" + attackPoints +
                '}';
    }
}
