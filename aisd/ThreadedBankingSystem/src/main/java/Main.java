import java.awt.*;

/**
 * Created by RENT on 2017-09-12.
 */
public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();

        for (int i = 0; i < 1000; i++) {
            bank.add(5.0);
            bank.sub(5.0);
        }
        try {
            Thread.sleep(0);
            bank.balance();
            System.out.println("bum");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
