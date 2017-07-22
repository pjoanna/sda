package oop.family;

/**
 * Created by RENT on 2017-07-12.
 */
public abstract class FamilyMember {
    private String name;
    private boolean isAdult;

    public FamilyMember(String name, boolean isAdult) {
        this.name = name;
        this.isAdult = isAdult;
    }

    public String getName() {
        return name;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void introduce();//potrzebujem metody ktora nic nie robi
    // ale chcemy ją nadpisywać w innych klasach
    // więc jest konieczna - piszemy ze jest abstrakcyjna
    // gdy chociaż jedna metoda jest abstrakcyjna to cała klasa jest abstrakcyjna!!!
    // ale: klasa


}
