import java.time.LocalDateTime;

/**
 * Created by RENT on 2017-09-14.
 */
public class DateTimeSkill extends AbstractSkill {
    @Override
    public void run() {
        System.out.println("Aktualna data i czas: " + LocalDateTime.now());
    }
}
