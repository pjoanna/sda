package mutability;

/**
 * Created by RENT on 2017-07-22.
 */
public class IntegerImmutableExample {
    public static void main(String[] args) {
        Integer a = 1000;
        Integer b = 1000;

        // a == b zachowuje się inaczej dla liczb z zakresu <-128 ; 127> a inaczej dla pozostałych liczbIntExample
        System.out.println(a == b); // porównuje wartość i referencje - tutaj dla obiektów są różne miejsca w pamięci - false
        System.out.println(a.equals(b)); // porównuje tylko wartość

        b = 400;
        a = b;
        System.out.println(a == b); //true - obiekty a i b wskazują na to samo
        b = 300;

        System.out.println(a == b);  // false
        System.out.println(a.equals(b)); // false
        System.out.println(a);
        System.out.println(b);
    }

}
