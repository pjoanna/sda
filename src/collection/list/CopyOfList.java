package collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-07-15.
 */
public class CopyOfList {


    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("aa","aa"));
        list.add(new User("bb","bb"));
        list.add(new User("cc","cc"));

        List<User> copy = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            try {
                copy.add((User) (list.get(i).clone()));
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

    }
}
