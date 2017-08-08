import java.time.LocalDateTime;

/**
 * Created by pjoanna on 2017-08-08.
 */
public class Main {

    private static long id = 1;

    public static void main(String[] args) {
        Record record0 = createRecord(9,12, "pierwszy");
        Record record1 = createRecord(13, 22, "drugi");
        Record record2 = createRecord(13, 22, "trzeci");
        Record record3 = createRecord(11, 22, "czwarty");
        Record record4 = createRecord(11, 22, "piąty");

        Database database = new Database();

        database.addRecord(record0);
        database.addRecord(record1);
        database.addRecord(record2);
        database.addRecord(record3);
        database.addRecord(record4);

        database.findRecord(2L);

        database.refresh();

        database.findRecord(2L);
        database.refresh();
        database.findRecord(2L);

    }

    private static Record createRecord(int endHour, int endMinute, String name) {
        LocalDateTime endTime = LocalDateTime.of(2017, 8, 9 ,endHour, endMinute);
        LocalDateTime startTime = LocalDateTime.of(2017, 8, 8, 10, 22);
        return new Record(startTime, endTime, id++, name);
    }

}
