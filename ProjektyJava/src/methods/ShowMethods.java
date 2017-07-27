package methods;

/**
 * Created by RENT on 2017-07-11.
 */
// PRZECIĄŻANIE !! te same nazwy metod, różne typy argumentów (różne listy argumentów) == polimorfizm statyczny
public class ShowMethods {
    public static void main(String[] args) {
        int i = 1;
        double d = 2;
        String word = "siemka";

        show(i);
        show(d);
        show(word);

    }

    public static void show(int number){
        System.out.println("Integer: "+number);

    }
    public static void show(double number){
        System.out.println("Double: "+number);

    }
    public static void show(String word){
        System.out.println("String: "+word);

    }
}
