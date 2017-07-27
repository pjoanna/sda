package throwables;

/**
 * Created by RENT on 2017-07-15.
 */
public class TryCatch {
    public static void main(String[] args) {

        System.out.println("Start");
        try {
            int a = 4 / 2;
            int b = 4 / 0;
            int c = 4 / 1;

            System.out.println(c);
        }catch (ArithmeticException e){
            System.out.println("Błąd");
        }finally {
            System.out.println("Finally");
        }
        System.out.println("Koniec");

    }
}
