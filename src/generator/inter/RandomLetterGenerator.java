package generator.inter;

import java.util.Random;

/**
 * Created by RENT on 2017-07-22.
 */
public class RandomLetterGenerator implements Generator<Character>{
    private final Random random = new Random();
    private static final char BEFORE_A = 'a'-1;
    private static final char LETTER_Z = 'z';

    public Character generate(){
        int interval = LETTER_Z-BEFORE_A;
        int letterNumber = random.nextInt(interval)+'a';
        char letter = (char)letterNumber;

        return letter;
    }

    public static void main(String[] args) {
        RandomLetterGenerator generator = new RandomLetterGenerator();
        GeneratorMethods.printTenElements(generator);

    }
}
