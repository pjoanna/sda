package decorator;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class BasicSportsMan implements Sportsman {

    @Override
    public void prepare() {
        System.out.println("Rozciaganie...");
    }

    @Override
    public void doPumps(int number) {
        for(int i=1; i<=number; i++){
            System.out.println(i + " pompka");
        }
    }

    @Override
    public void doSquats(int number) {
        for(int i=1; i<=number; i++){
            System.out.println(i + " przysiad");
        }
    }

    @Override
    public void doCrunches(int number) {
        for(int i=1; i<=number; i++){
            System.out.println(i + " brzuszek");
        }
    }
}
