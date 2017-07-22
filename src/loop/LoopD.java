package loop;

/**
 * Created by RENT on 2017-07-08.
 */
public class LoopD {
    public static void main(String[] args) {
        for (int i = 0; i < 26; i++) { /// nie robić tak, bo dla nikogo to nie nie jest czytelne że a to 97 :P
            System.out.println((char)(i+97));
        }

        for (char c = 'a'; c < 'z'; c++) { /// WAŻNE!!
            System.out.println(c);
        }
    }
}
