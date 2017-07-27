package oop.family;

/**
 * Created by RENT on 2017-07-12.
 */
public class Daughter extends FamilyMember {
    public Daughter(String name) {
        super(name,false);
    }

    @Override
    public void introduce() {
        System.out.println("I am a daughter. My name is "+getName());
    }
}
