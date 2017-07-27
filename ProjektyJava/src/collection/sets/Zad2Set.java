package collection.sets;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by RENT on 2017-07-17.
 */
public class Zad2Set {


    public static boolean containDuplicates(String text) {
        boolean value;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            set.add(text.charAt(i));
        }
        for (Character character : set) {
            System.out.println(character);
        }
        return text.length() == set.size();
    }

    public static void main(String[] args) {
        String word = "dach";
        if (containDuplicates(word)) {
            System.out.println("Znaki się nie powtarzają");
        } else {
            System.out.println("Znaki się powarzają");
        }



    }
}
