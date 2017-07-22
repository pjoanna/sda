package collection.sets;

import java.util.HashSet;
import java.util.Set;
// hashset nie sortuje; treeset sortuje mimo braku porzadku :P
/**
 * Created by RENT on 2017-07-17.
 */
public class SetExamples {
    public static void main(String[] args) {
        Set<Character> characters = new HashSet<>();
        characters.add('a');
        characters.add('z');
        characters.add('t');
        characters.remove('z');
        characters.iterator();//przeglądanie kolecji
        System.out.println(characters.iterator().next());
        System.out.println(characters.contains('a'));
        System.out.println(characters.contains('z'));

        System.out.println("for each");
        for (Character c : characters) {
            System.out.println(c);
        }
        System.out.println("size "+characters.size());
        System.out.println("clear");
        characters.clear();  //usuwa wszystkie elementy zbioru

        System.out.println("size "+characters.size());

    }
}
