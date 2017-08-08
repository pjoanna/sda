/**
 * Created by pjoanna on 2017-08-08.
 */
public class Office {

    public void handle(Client client){
        System.out.println("Klient pesel: "+ client.getPesel() + " załatwia sprawę " + client.getBusiness());
    }
}
