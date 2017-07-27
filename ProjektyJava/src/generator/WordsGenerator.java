package generator;

/**
 * Created by RENT on 2017-07-22.
 */
public class WordsGenerator {
    private RandomLetterGenerator randomLetterGenerator = new RandomLetterGenerator();
    private RandomNumbersFromIntervalGenerator wordLengthGenerator;

    public WordsGenerator(int minLength, int maxLength) {
        this.wordLengthGenerator = new RandomNumbersFromIntervalGenerator(minLength, maxLength);
    }

    public String generate() {
        String word = "";
        int length = wordLengthGenerator.generate();
        for (int i = 0; i < length; i++) {
            word += randomLetterGenerator.generate();
        }
        return word;
    }

    public static void main(String[] args) {
        WordsGenerator wordsGenerator = new WordsGenerator(2, 10);

        for (int j = 0; j < 15; j++) {
            System.out.println(wordsGenerator.generate());
        }
    }
}
