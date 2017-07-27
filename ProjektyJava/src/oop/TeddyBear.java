package oop;

/**
 * Created by RENT on 2017-07-12.
 */
public class TeddyBear {
    private String name;

    public TeddyBear(String name){
        this.name = name;
    }

    public void printName(){
        System.out.println(name);;
    }

    public static void main(String[] args) {
        TeddyBear teddyBear = new TeddyBear("Tom");
        teddyBear.printName();
    }
}
