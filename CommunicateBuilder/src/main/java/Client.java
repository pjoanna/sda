import java.util.List;

/**
 * Created by RENT on 2017-08-08.
 */
public class Client {
    private String name;
    private List<Mail> mails;

    public Client(String name, List<Mail> mails) {
        this.name = name;
        this.mails = mails;
    }

    public void readMail(Mail mail){
        mails.add(mail);
        System.out.println("Klient "+ this.getName() + " otrzymał maila");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Mail> getMails() {
        return mails;
    }

    public void setMails(List<Mail> mails) {
        this.mails = mails;
    }
}
