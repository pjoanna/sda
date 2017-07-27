import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by RENT on 2017-07-26.
 */
public class Utils {
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Can't divide by zero");
        }
        return a / b;
    }

    public static boolean arrayEquals(int[] array1, int[] array2) {
        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] == array2[i]) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public static String rand(String[] data){
        Random random = new Random();
        return data[random.nextInt(data.length-1)];
    }

    public static int nwd(int a, int b){
        while (a != b){
            if (a > b)
                a -= b;
            else
                b -= a;
        }
        return a;
    }

    public static int[] fillArray(int[] array, int element){
        for (int i = 0; i < array.length; i++) {
            array[i] = element;
        }
        return array;
    }


    public static List<Integer> newListCreate(int... elements){
        List<Integer> list = new ArrayList<>();
        for (int element : elements) {
            list.add(element);
        }
        return list;
    }


}
