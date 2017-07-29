package cities.app;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RENT on 2017-07-29.
 */
public class UserInterface {
    private Map<Message, String> messageToString;

    public UserInterface(Map<Message, String> messageToString) {
        this.messageToString = messageToString;
    }

    public void showMessage(Message message) {
        System.out.println(messageToString.getOrDefault(message, "Brak tłumaczenia dla " + message.name()));
    }

    public void showCityDetails(City city) {
        String formatted = String.format(
                messageToString.get(Message.CITY_DETAILS),
                city.getId(),
                city.getName(),
                city.getCitizens(),
                city.getArea());
        System.out.println(formatted);
    }

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface(polishTranslation());
        userInterface.showMessage(Message.HELLO_WORLD);
        userInterface.showMessage(Message.CITY_DOESNT_EXIST);
        userInterface.showCityDetails(new City(1L, "Sopot", 900, 339.8));
    }

    public enum Message {
        HELLO_WORLD,
        CITY_DOESNT_EXIST,
        CITY_DETAILS,
        NEW_CITY_ADDED,
        CITY_UPDATED,
        CITY_DELETED,
        APP_CLOSED, NEXT_COMMAND;
    }

    public static Map<Message, String> polishTranslation() {
        Map<Message, String> translation = new HashMap<>();
        translation.put(Message.HELLO_WORLD, "Witaj Świecie!");
        translation.put(Message.CITY_DOESNT_EXIST, "Podane miasto nie istnieje w bazie!");
        translation.put(Message.CITY_DETAILS, "Id : %d\nMiasto : %s\nLiczba ludności : %d\nPowierzchnia : %.3f");
        return translation;
    }

    private static Map<Message, String> englishTranslation() {
        Map<Message, String> translation = new HashMap<>();
        translation.put(Message.HELLO_WORLD, "Hello World!");
        translation.put(Message.CITY_DOESNT_EXIST, "This city doesn't exist!");
        translation.put(Message.CITY_DETAILS, "Id : %d\nCity : %s\nCitizens : %d\nArea : %.3f");
        return translation;
    }


}



