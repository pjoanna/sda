package decorator;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class FitnessStudio {
    public void train(Sportsman sportsman){
        sportsman.prepare();
        sportsman.doPumps(3);
        sportsman.doSquats(2);
        sportsman.doCrunches(5);
    }
}
