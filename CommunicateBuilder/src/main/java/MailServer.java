import java.time.LocalDate;
import java.util.List;

/**
 * Created by RENT on 2017-08-08.
 */
public class MailServer {
    private List<Client> clients;

    public void connect(Client client){
        clients.add(client);
    }

    public void disconnect(Client client){
        clients.remove(client);
    }

    public void sendMessage(Mail mail, Client sender){
        clients.remove(sender);
        List<Client> clients1 = clients;
        LocalDate date = LocalDate.now();
        mail.setDataOdbioru(date);
        for (Client client : clients1) {
            client.readMail(mail);
        }
    }
}
