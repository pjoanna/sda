package generator;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by RENT on 2017-07-22.
 */
public class RandomCharSequenceGenerator {
    private Set<Character> characters;

    public RandomCharSequenceGenerator(Set<Character> characters) {
        this.characters = characters;
    }

    public static RandomCharSequenceGenerator from(char... chars) {
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            characters.add(chars[i]);
        }
        return new RandomCharSequenceGenerator(characters);
    }

//    public RandomCharSequenceGenerator(char... chars) {
//        for (int i = 0; i < chars.length; i++) {
//            this.characters.add(chars[i]);
//        }
//    }

    public static void main(String[] args) {

        RandomCharSequenceGenerator generator = from('a', 'b');

    }

}
