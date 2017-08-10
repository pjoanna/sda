/**
 * Created by RENT on 2017-08-10.
 */
public class TicketGenerator {
    private static TicketGenerator ourInstance = new TicketGenerator();

    public static TicketGenerator getInstance() {
        return ourInstance;
    }

    private TicketGenerator() {
    }

}
