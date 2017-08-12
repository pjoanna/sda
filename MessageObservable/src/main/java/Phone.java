import java.util.Observable;
import java.util.Observer;

/**
 * Created by RENT on 2017-08-10.
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
        if (arg instanceof Message){
            Message messageReceived = (Message) arg;
            String numberReceived = messageReceived.getNumber();
            String textReceived = messageReceived.getText();
            if (numberReceived.equals(number)){
                System.out.println("wiadomość dotarła do odpowiedniego telefonu");
            } else {
                System.out.println("wiadomość dotarła do nieodpowiedniego telefonu");
            }

        }
    }
}
