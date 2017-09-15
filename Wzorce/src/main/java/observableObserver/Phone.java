package observableObserver;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by pjoanna on 2017-08-22.
 */
public class Phone implements Observer {
    private String number;

    public Phone(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Message) {
            Message messageReceived = (Message) arg;
            String numberReceived = messageReceived.getNumber();
            if (numberReceived.equals(number)) {
                System.out.println("wiadomość dotarła do odpowiedniego telefonu " + getNumber());
            } else {
                System.out.println("wiadomość dotarła do nieodpowiedniego telefonu " + getNumber());
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return number != null ? number.equals(phone.number) : phone.number == null;
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }
}
