package decorator;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class Main {
    public static void main(String[] args) {

        FitnessStudio fitnessStudio = new FitnessStudio();
        Sportsman sportsman = new WaterDrinking(new NoPrepare(new BasicSportsMan()));
        fitnessStudio.train(sportsman);
    }
}
