package my.arrays;

/**
 * Created by RENT on 2017-07-08.
 */
public class Array1Words {
    public static void main(String[] args) {
        String[] words = {"bird","cat","dog","mouse"};
        String[] words1 = "aa,bb,cc,dd".split(","); // split rozdziela elementy oddzielone przecinkami na osobne elmenty tablicy

        for(String word : words){
            System.out.println(word);
        }
        for (int i = words.length-1; i >= 0; i--) {
            System.out.println(words[i]);
        }

        for (int i = 0; i < words.length; i++){
            System.out.println(words[i]);
        }

    }
}
