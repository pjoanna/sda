import java.util.List;

/**
 * Created by RENT on 2017-08-12.
 */
public class User {
    private Integer id;
    private String nick;
    private List<String> messages;
    private boolean isAdmin;
    
    private static int counter = 0;

    public User(String nick) {
        this.id = counter++;
        this.nick = nick;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Integer getId() {
        return id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
