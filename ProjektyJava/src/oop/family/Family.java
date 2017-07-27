package oop.family;

/**
 * Created by RENT on 2017-07-12.
 */
public class Family {
    public static void main(String[] args) {

        Mother mother = new Mother("Anna");
        Daughter daughter = new Daughter("Alice");
        Father father = new Father("Peter");
        Son son = new Son("Pablo");
        FamilyMember[]members = {mother, daughter, son, father};


        for(FamilyMember member : members){
            member.introduce();
            if (member.isAdult()){
                System.out.println("I am an adult");
            }
        }

    }
}
