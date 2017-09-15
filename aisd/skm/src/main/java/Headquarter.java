import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Observable;

/**
 *
 * DODATKOWE: zamień implementację headquarters na JFrame, lub dodaj w niej implementację tak aby w tej klasie pojawilo sie okno
 * (dodaj interfejs GUI) aby na okienku (headquarters) wyswietalala sie lista wszystkich pociagow. (podobnie jak pralki)
 *
 * Created by amen on 9/13/17.
 */
public class Headquarter extends Observable implements Observer {

    public final static Boolean DIRECTION_WEJHEROWO = false;// wejherowo to stacja (stations.length -1)
    public final static Boolean DIRECTION_GDANSK = true;    // gdansk to stacja 0
    private ExecutorService trains = Executors.newFixedThreadPool(10);

    private TrainSchedule scheduleFromGdansk;
    private TrainSchedule scheduleFromWejherowo;
    private List<Station> stationList;

    public Headquarter() {
        this.scheduleFromGdansk = new TrainSchedule(new LinkedList<TrainScheduleRecord>(
                Arrays.asList(new TrainScheduleRecord[]{
                        new TrainScheduleRecord(10000, false),
                        new TrainScheduleRecord(5000, false),
                        new TrainScheduleRecord(8000, false),
                        new TrainScheduleRecord(500, false),
                        new TrainScheduleRecord(10000, false),
                })));

        this.scheduleFromWejherowo = new TrainSchedule(new LinkedList<TrainScheduleRecord>(
                Arrays.asList(new TrainScheduleRecord[]{
                        new TrainScheduleRecord(10000, false),
                        new TrainScheduleRecord(5000, false),
                        new TrainScheduleRecord(8000, false),
                        new TrainScheduleRecord(500, false),
                        new TrainScheduleRecord(10000, false),
                })));

        stationList = new LinkedList<Station>(
                Arrays.asList(new Station[]{
                        new Station(0, scheduleFromGdansk, scheduleFromWejherowo),
                        new Station(1, scheduleFromGdansk, scheduleFromWejherowo),
                        new Station(2, scheduleFromGdansk, scheduleFromWejherowo),
                        new Station(3, scheduleFromGdansk, scheduleFromWejherowo),
                        new Station(4, scheduleFromGdansk, scheduleFromWejherowo),
                }));


    }

    public void dispatchTrainFromGdansk() {
        Train t = new Train(0, DIRECTION_WEJHEROWO, scheduleFromGdansk);
        t.addObserver(this);
        trains.submit(t);

    }

    public void dispatchTrainFromWejherowo() {
        Train t = new Train(0, DIRECTION_GDANSK, scheduleFromWejherowo);
        t.addObserver(this);
        trains.submit(t);
    }

    public void update(Observable o, Object arg) {
        // informuje że wjechał na stacje
        setChanged();
        notifyObservers();

        // jest informowany o tym że jakiś pociąg dojechał do stacji
        if (o instanceof Train){
            Train t = (Train) o;
            for (int i = t.getStationId(); i < stationList.size(); i++) {
                stationList.get(i).update(t, "info");
            }
        }
        // to jakie stacje muszą być poinformowane wybieracie WY
    }

    public void printTrainInfoOf(int id){
        // wypisz tablice pociagow stacji z identyfikatorem id;
        System.out.println(stationList.get(id).toString());


    }

    get
}