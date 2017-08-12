/**
 * Created by RENT on 2017-08-12.
 */
public class Order {
    private String productName;
    private int amount;

    public Order(Request request) {
        String[] requestContentSplits = request.getContent().split(" ");
        this.productName = requestContentSplits[0];
        this.amount = Integer.parseInt(requestContentSplits[1]);
    }


}
