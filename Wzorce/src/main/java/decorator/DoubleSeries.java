package decorator;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class DoubleSeries implements Sportsman {
    private Sportsman sportsman;

    public DoubleSeries(Sportsman sportsman) {
        this.sportsman = sportsman;
    }

    @Override
    public void prepare() {
        sportsman.prepare();
    }

    @Override
    public void doPumps(int number) {
        sportsman.doPumps(number*2);
    }

    @Override
    public void doSquats(int number) {
        sportsman.doSquats(number*2);

    }

    @Override
    public void doCrunches(int number) {
        sportsman.doCrunches(number*2);

    }
}
