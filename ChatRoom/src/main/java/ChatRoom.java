import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

/**
 * Created by RENT on 2017-08-12.
 */
public class ChatRoom extends Observable {
    private Map<Integer, User> userMap;
    private String roomName;


    public ChatRoom(Map<Integer, User> userMap, String roomName) {
        this.userMap = userMap;
        this.roomName = roomName;

        User admin1 = new User("admin1");
        admin1.setAdmin(true);
        User admin2 = new User("admin2");
        admin2.setAdmin(true);
        User admin3 = new User("admin3");
        admin3.setAdmin(true);
        User admin4 = new User("admin4");
        admin4.setAdmin(true);

        userMap.put(admin1.getId(), admin1);
        userMap.put(admin2.getId(), admin2);
        userMap.put(admin3.getId(), admin3);
        userMap.put(admin4.getId(), admin4);

    }

    public void userLogin(String nick){
        User user = new User(nick);
        userMap.put(user.getId(), user);
    }

    public void sendMessage(Integer userId, String message){
            setChanged();
            notifyObservers();
    }
    public void kickUser(Integer idKickedUser, Integer idKickingUser){
        List<Integer> adminsID = new ArrayList<>();
        for (User user : userMap.values()) {
           if(user.isAdmin()){
               adminsID.add(user.getId());
           }
        }
        if (adminsID.contains(idKickedUser)){
            System.out.println("Kickujacy to admin");
        }else {
            System.out.println("Kickujący nie jest admin");
        }

    }
}
