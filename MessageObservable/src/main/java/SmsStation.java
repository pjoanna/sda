import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by RENT on 2017-08-10.
 */
public class SmsStation extends Observable {
    private List<Phone> phoneList = new ArrayList<>();
    public void addPhone(Phone phone){
        phoneList.add(phone);

    }
    public void sendSMS(String number, String text){
        Message message = new Message(number, text);
    }

    public SmsStation() {
        for(int i = 0; i < 10; i++){
            Phone phone = new Phone("1151442L");
            addPhone(phone);
            addObserver((Observer) phone);
        }
    }

    public void handleSMS(String text){
        setChanged();
        notifyObservers(text);
    }
}
