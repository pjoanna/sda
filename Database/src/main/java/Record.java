import java.time.LocalDateTime;

/**
 * Created by RENT on 2017-08-07.
 */
public class Record {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long id;
    private String name;


    public Record(LocalDateTime startTime, LocalDateTime endTime, long id, String name) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = id;
        this.name = name;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public long getId() {
        return id;
    }
}
