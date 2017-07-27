package collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-07-15.
 */
public class User implements Cloneable{
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new User(name,password);
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Adam","aa"));
        users.add(new User("Basia", "bb"));
        users.add(new User("Czesia", "cc"));

        for (User user : users) {
            System.out.println("Imię: "+user.getName()+" hasło: "+user.getPassword());
        }


    }
}
