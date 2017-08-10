/**
 * Created by RENT on 2017-08-10.
 */
public enum ActionType {
    REGISTER(0.4), UNREGISTER(0.4), CALL(0.15), COMPLAIN(0.05);

    Double probability;
    ActionType(Double probability){
        this.probability = probability;
    }

}
