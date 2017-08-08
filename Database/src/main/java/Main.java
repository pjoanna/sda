import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by pjoanna on 2017-08-08.
 */
public class Main {
    public static void main(String[] args) {
        Record record0 = new Record(LocalDateTime.of(2017, 8, 8, 3,22), Time.valueOf(LocalTime.of(3,50)), 1L, "pierwszy");
        Record record1 = new Record(LocalDateTime.of(2017, 8, 8, 3,22), Time.valueOf(LocalTime.of(2,44)), 2L, "drugi");
        Record record2 = new Record(LocalDateTime.of(2017, 8, 8, 3,22), Time.valueOf(LocalTime.of(1,30)), 3L, "trzeci");
        Record record3 = new Record(LocalDateTime.of(2017, 8, 8, 3,22), Time.valueOf(LocalTime.of(2,50)), 4L, "czwarty");
        Record record4 = new Record(LocalDateTime.of(2017, 8, 8, 3,22), Time.valueOf(LocalTime.of(2,48)), 5L, "piąty");

        Database database = new Database();

        database.addRecord(1L, record0);
        database.addRecord(2L, record1);
        database.addRecord(3L, record2);
        database.addRecord(4L, record3);
        database.addRecord(5L, record4);

        database.findRecord(2L);

        database.refresh();

        database.findRecord(2L);

    }

}
