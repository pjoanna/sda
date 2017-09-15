/**
 * Created by RENT on 2017-09-08.
 */
public class Main {
    public static void main(String[] args) {
        ONP onp = new ONP("4 - 5 * ( 2 + 10 )");
        System.out.println(onp.convertToONP());
        onp.countONP(onp.convertToONP());
    }
}
