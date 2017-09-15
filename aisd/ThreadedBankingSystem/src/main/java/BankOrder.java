/**
 * Created by RENT on 2017-09-12.
 */
public class BankOrder implements Runnable {
    private OperationType type;
    private double amount;
    private BankAccount account;

    public BankOrder(OperationType type, double amount, BankAccount account) {
        this.type = type;
        this.amount = amount;
        this.account = account;
    }

    public void run() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        switch (type) {
            case ADD:
                account.addToAccount(amount);
                break;
            case SUBSTRACT:
                account.substractFromAccount(amount);
                break;
            case BALANCE:
                account.getAmount();
                break;
            default:
                break;


        }
    }
}
