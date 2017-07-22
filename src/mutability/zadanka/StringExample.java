package mutability.zadanka;

/**
 * Created by RENT on 2017-07-22.
 */
public class StringExample {

    public static void main(String[] args) {

        String text = generate('a', 50);
        System.out.println(text);
    }

    private static String generate(char c, int length) {
        String text = "";
        for (int i = 0; i < length; i++) {
            text += c;
        }
        return text;
    }
}
