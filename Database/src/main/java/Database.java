import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by pjoanna on 2017-08-08.
 */
public class Database {
    private final Map<Long, Record> recordMap = new HashMap<>();

    public void addRecord(Long id, Record record) {
        recordMap.put(id, record);
    }

    public Record findRecord(Long id) {
        for (Map.Entry<Long, Record> recordEntry : recordMap.entrySet()) {
            if (recordEntry.getKey().equals(id)) {
                System.out.println("Znaleziono szukany rekord");
                return recordEntry.getValue();

            }
        }
        return null;
    }

    public void refresh() {
        Iterator<Map.Entry<Long, Record>> iterator = recordMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Record record = iterator.next().getValue();
            Timestamp lifeStart = Timestamp.valueOf(record.getLocalDateTime());
            Timestamp now = Timestamp.valueOf(LocalDateTime.now());
            Long lifeTime = record.getLifeTime().getTime();

            System.out.println(now.getTime()+"  now" );
            System.out.println(lifeStart.getTime()+ "  start" );
            System.out.println(lifeTime+"  czas trwania");

            Long period = now.getTime() - lifeStart.getTime() - lifeTime;
            if (period <= 0) {
                System.out.println("Rekord " + record.getName() + " i id: " + record.getId() + "jest przedawniony i został usunięty");
                recordMap.remove(record);

            }
        }

    }

}

