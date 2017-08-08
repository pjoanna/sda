import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by RENT on 2017-08-07.
 */
public class Record {
    private LocalDateTime localDateTime;
    private Time lifeTime;
    private long id;
    private String name;


    public Record(LocalDateTime localDateTime, Time lifeTime, long id, String name) {
        this.localDateTime = localDateTime;
        this.lifeTime = lifeTime;
        this.id = id;
        this.name = name;
    }

    public Time getLifeTime() {
        return lifeTime;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public long getId() {
        return id;
    }
}
