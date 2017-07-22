package mutability;

/**
 * Created by RENT on 2017-07-22.
 */
public class IntegerMutableExample {
    public static void main(String[] args) {
        IntegerMutable a = new IntegerMutable(1000);
        IntegerMutable b = new IntegerMutable(1000);
        IntegerMutable c = new IntegerMutable(500);

        System.out.println(a == b);  //false
        System.out.println(a.equals(b));  // true

        b.setValue(400);
        a = b;
        System.out.println(a == b); // true
        b.setValue(300); // setter podmienia wartość danego obiektu w tym samym miejscu w pamięci

        System.out.println(a == b);  // true
        System.out.println(a.equals(b)); // true
        System.out.println(a.getValue()); //300
        System.out.println(b.getValue()); //300

        b = c;

        System.out.println(a == b);  // false
        System.out.println(a.equals(b)); // false
        System.out.println(a.getValue()); //300
        System.out.println(b.getValue()); //500


    }
}
