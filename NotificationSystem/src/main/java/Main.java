import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by RENT on 2017-09-18.
 */
public class Main {
    public static void main(String[] args) {
        List<Program> programs = new ArrayList<Program>();
        programs.add(new Program("program111"));
        programs.add(new Program("program222"));
        programs.add(new Program("program333"));

        Random random = new Random();
        int programName = random.nextInt(programs.size());


        Watcher watcher = new Watcher();
        NewsStation station = new NewsStation(programs.get(programName));
        station.addObserver(watcher);
        station.show();

    }
}
