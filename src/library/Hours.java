package library;

/**
 * Created by RENT on 2017-07-18.
 */
public class Hours {
    private int from;
    private int to;
    private boolean status;

    public void setFrom(int from) {
        this.from = from;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public Hours(int from, int to) {
        this.from = from;
        this.to = to;
        this.status = false;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public Hours workHours(){
        Hours hours = new Hours(from, to);
        return hours;
    }

    //public boolean ifWork(){}
}
