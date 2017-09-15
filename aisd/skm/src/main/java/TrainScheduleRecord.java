public class TrainScheduleRecord {
    private long time;
    private boolean skip;

    public TrainScheduleRecord(long time, boolean skip) {
        this.time = time;
        this.skip = skip;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }
}