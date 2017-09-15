import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by RENT on 2017-09-12.
 */
public class Bank {
    private BankAccount account = new BankAccount();
    private ExecutorService threads = Executors.newFixedThreadPool(100);

    public Bank() {
    }

    public void add (double howMuch){
        BankOrder order = new BankOrder(OperationType.ADD, howMuch, account);
        order.run();
        threads.submit(order);
    }

    public void sub (double howMuch){
        BankOrder order = new BankOrder(OperationType.SUBSTRACT, howMuch, account);
        order.run();
        threads.submit(order);
    }

    public void balance(){
        BankOrder order = new BankOrder(OperationType.BALANCE, 0.0, account);
        order.run();
        threads.submit(order);
    }


}
