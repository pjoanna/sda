package oop.family;

/**
 * Created by RENT on 2017-07-12.
 */
public class Father extends FamilyMember{
    public Father(String name) {
        super(name, true);
    }

    @Override
    public void introduce() {
        System.out.println("I am a father. My name is "+getName());
    }
}
