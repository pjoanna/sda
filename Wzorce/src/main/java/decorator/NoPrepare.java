package decorator;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class NoPrepare implements Sportsman{
    private Sportsman sportsman;

    public NoPrepare(Sportsman sportsman) {
        this.sportsman = sportsman;
    }

    @Override
    public void prepare() {}

    @Override
    public void doPumps(int number) {
        sportsman.doPumps(number);
    }

    @Override
    public void doSquats(int number) {
        sportsman.doSquats(number);

    }

    @Override
    public void doCrunches(int number) {
        sportsman.doCrunches(number);

    }
}
