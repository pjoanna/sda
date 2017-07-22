package generator;

/**
 * Created by RENT on 2017-07-22.
 */
public class LetterSequenceGenerator {          // generator kolejnych liter alfabetu
    private int counter = 0;

    public int generate1(){
        return counter++%('z'-('a'-1))+'a';
    }

    public static final char BEFORE_A = 'a' - 1;
    private char letter = BEFORE_A;

    public char generate(){
        if(letter == 'z') {
            letter = BEFORE_A;
        }
        letter++;
        return letter;
    }

    public static void main(String[] args) {
        LetterSequenceGenerator generator = new LetterSequenceGenerator();
        for (int i = 0; i < 35; i++) {
            System.out.println((char) generator.generate1());
        }

    }
}
