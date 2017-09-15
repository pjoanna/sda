package observableObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class SmsStation extends Observable{
    private List<Phone> phoneList = new ArrayList<>();

    public void addPhone(Phone phone) {
        phoneList.add(phone);
        addObserver(phone);
    }

    public void sendSMS(String number, String text) {
        Message message = new Message(number, text);
        setChanged();
        notifyObservers(message);
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }


    public void addPhonesOnStart() {
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            counter++;
            Phone phone = new Phone("1110" + counter);
            System.out.println("stworzono telefon o numerze " + phone.getNumber());
            addPhone(phone);
        }
    }
}
