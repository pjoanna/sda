import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Reprezentuje pojedyncza stacje kolejowa.
 *
 * DODATKOWE: zamień implementację station na JPanel (dodaj interfejs GUI) aby na okienku (headquarters)
 * wyswietalala sie lista wszystkich pociagow.
 * Created by amen on 9/13/17.
 */
public class Station implements Observer {

    private int id;
    private TrainSchedule fromGdansk;   //grafik w jedna strone
    private TrainSchedule fromWejherowo;//grafik w druga strone

    private List<TrainInfo> listOfTrainsFromGdansk;
    private List<TrainInfo> listOfTrainsFromWejherowo;

    public Station(int id, TrainSchedule fromGdansk, TrainSchedule fromWejherowo) {
        this.id = id;
        this.fromGdansk = fromGdansk;
        this.fromWejherowo = fromWejherowo;

        this.listOfTrainsFromGdansk = new ArrayList<TrainInfo>();
        this.listOfTrainsFromWejherowo = new ArrayList<TrainInfo>();
    }

    public void update(Observable o, Object arg) {
        // lista wyświetla pociągi zgodnie z tym, co ruszyło już ze stacji.
        for (TrainInfo info : listOfTrainsFromGdansk) {
            System.out.println("Pociąg: "+ info.getTrain_id() + " przybędzie na stację " + this.fromGdansk.toString() + " za: " + info.getEstimatedTimeOfArrival());
        }
        for (TrainInfo info : listOfTrainsFromWejherowo) {
            System.out.println("Pociąg: "+ info.getTrain_id() + " przybędzie na stację " + this.fromWejherowo.toString() + " za: " + info.getEstimatedTimeOfArrival());
        }

        // tutaj musi pojawić się "skomplikowana" logika oceny czasu dojazdu pociągu.
        // UWAGA! stacja nie wie o tym że pociąg nie zatrzymuje się na stacjach (innych niż ona sama)
        // UWAGA! (nie ma tego brać pod uwagę przy obliczaniu czasu dojazdu) więc pociagi beda zmienialy czasy dojazdow
        // Spróbuj użyć komparatora (liste listOfTrainsFromGdansk oraz listOfTrainsFromWejherowo zamien na priorityqueue)
    }
}