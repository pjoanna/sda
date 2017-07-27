package generator.inter;

/**
 * Created by RENT on 2017-07-22.
 */
public class LetterSequenceGenerator implements Generator<Character> {          // generator kolejnych liter alfabetu
    private int counter = 0;

    public int generate1(){
        return counter++%('z'-('a'-1))+'a';
    }

    public static final char BEFORE_A = 'a' - 1;
    private Character letter = BEFORE_A;

    public Character generate(){
        if(letter == 'z') {
            letter = BEFORE_A;
        }
        letter++;
        return letter;
    }

    public static void main(String[] args) {
        LetterSequenceGenerator generator = new LetterSequenceGenerator();
      //  GeneratorMethods.printTenElements(generator);
        GeneratorMethods.printEverySecondElement(generator);
    }
}
