package decorator;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class WaterDrinking implements Sportsman {
    private Sportsman sportsman;

    public WaterDrinking(Sportsman sportsman) {
        this.sportsman = sportsman;
    }
    @Override
    public void prepare() {
        sportsman.prepare();
        System.out.println("Piję wodę");
    }

    @Override
    public void doPumps(int number) {
        sportsman.doPumps(number);
        System.out.println("Piję wodę");

    }

    @Override
    public void doSquats(int number) {
        sportsman.doSquats(number);
        System.out.println("Piję wodę");

    }

    @Override
    public void doCrunches(int number) {
        sportsman.doCrunches(number);
        System.out.println("Piję wodę");

    }

}
