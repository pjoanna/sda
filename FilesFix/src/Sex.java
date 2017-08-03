/**
 * Created by pjoanna on 2017-08-03.
 */
public enum Sex {
    MALE,
    FEMALE,
    UNKNOWN;


    public static Sex parse(String s) {
        if (s.equals("m")) {
            return MALE;
        }
        if (s.equals("k")) {
            return FEMALE;
        }
        return UNKNOWN;
    }
}
