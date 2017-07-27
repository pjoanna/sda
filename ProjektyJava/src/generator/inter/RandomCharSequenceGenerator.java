package generator.inter;

import java.util.*;

/**
 * Created by RENT on 2017-07-22.
 */
public class RandomCharSequenceGenerator implements Generator<String>{
    private List<Character> characters;
    private Random random = new Random();

    public RandomCharSequenceGenerator(List<Character> characters) {
        this.characters = characters;
    }

    public static RandomCharSequenceGenerator from(char... chars) {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            characters.add(chars[i]);
        }
        return new RandomCharSequenceGenerator(characters);
    }
    public String generate(){
        String word = "";
        for (int i = 0; i < characters.size(); i++) {
            word += characters.get(random.nextInt(characters.size()));
        }
        return word;
    }

//    public RandomCharSequenceGenerator(char... chars) {
//        for (int i = 0; i < chars.length; i++) {
//            this.characters.add(chars[i]);
//        }
//    }

    public static void main(String[] args) {

        RandomCharSequenceGenerator generator = from('a', 'b','c','d','e','f');
        GeneratorMethods.printTenElements(generator);


    }

}
