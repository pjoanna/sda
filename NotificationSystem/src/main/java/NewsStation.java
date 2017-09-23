import java.util.List;
import java.util.Observable;

/**
 * Created by RENT on 2017-09-18.
 */
public class NewsStation extends Observable{
    private Program program;

    public NewsStation(Program program) {
        this.program = program;
    }

    public void show(){
        setChanged();
        notifyObservers(program);
    }

    public Program getProgram() {
        return program;
    }
}
