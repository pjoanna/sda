/**
 * Created by RENT on 2017-09-12.
 */
public class BankAccount {
    private double amount = 0;

    public void substractFromAccount(double howMuch){
        amount -= howMuch;

    }

    public void addToAccount(double howMuch){
        amount += howMuch;

    }

    public double getAmount(){
        return amount;
    }
}
