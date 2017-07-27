package oop.family;

/**
 * Created by RENT on 2017-07-12.
 */
public class Mother extends FamilyMember{
    public Mother(String name) {
        super(name, true);

    }

    @Override
    public void introduce() {
        System.out.println("I am a mother. My name is "+getName());
    }
}
