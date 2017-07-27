package mutability;

/**
 * Created by RENT on 2017-07-22.
 */
public class StringExample {
    public static void main(String[] args) {
        String a = "a"; //napisy wpisywane na sztywno są cachowane
        String b = "a";

        System.out.println(a==b); //t
        System.out.println(a.equals(b)); //t

        b = "bb";
        a = b;

        System.out.println(a==b); //t
        System.out.println(a.equals(b)); //t

        b = "bbb";

        System.out.println(a==b); // f
        System.out.println(a.equals(b)); //f
        System.out.println(a); //bbb
        System.out.println(b); //bbb

    }
}
