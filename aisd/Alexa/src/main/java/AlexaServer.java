import java.util.Observable;
import java.util.Observer;

/**
 * Created by RENT on 2017-09-14.
 */
public class AlexaServer implements Observer{
    private static AlexaServer ourInstance = new AlexaServer();

    public static AlexaServer getInstance() {
        return ourInstance;
    }

    private AlexaServer() {
    }

    public void update(Observable o, Object arg) {

        if (arg instanceof Request){
            Request request = (Request) arg;
            AbstractSkill requestParsed = parseRequest(request.getRequest());
            request.getDeviceToCall().invoke(requestParsed);
        }
    }

    public AbstractSkill parseRequest(String stringRequest){
        AbstractSkill abstractSkill;
        if (stringRequest.toLowerCase().startsWith("alexa what's the time") || stringRequest.toLowerCase().startsWith("alexa what time is it")){
            abstractSkill = new DateTimeSkill();
        }
        else {
            abstractSkill = new DontKnowSkill();
        }
        return abstractSkill;
    }
}
