package oop.family;

/**
 * Created by RENT on 2017-07-12.
 */
public class Son extends FamilyMember{
   public Son(String name) {
       super(name,false);
    }

    @Override
    public void introduce() {
        System.out.println("I am a son. My name is "+getName());
    }
}
