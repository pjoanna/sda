/**
 * Created by RENT on 2017-09-13.
 */
public class TrainInfo {
    private long estimatedTimeOfArrival;
    private int train_id;

    public TrainInfo(long estimatedTimeOfArrival, int train_id) {
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
        this.train_id = train_id;
    }

    public long getEstimatedTimeOfArrival() {
        return estimatedTimeOfArrival;
    }

    public void setEstimatedTimeOfArrival(long estimatedTimeOfArrival) {
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
    }

    public int getTrain_id() {
        return train_id;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }
}
