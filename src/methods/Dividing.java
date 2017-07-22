package methods;

/**
 * Created by RENT on 2017-07-11.
 */
public class Dividing {
    public static void main(String[] args) {
        printDivide(4,3);
        printDivide(4.0,3.0);

    }

    public static void printDivide(int a, int b){
        int result = a/b;
        int rest = a - result*b;
        System.out.println(result+" i "+rest+"/"+b);

    }
    public static void printDivide(double a, double b){
        double result = a/b;
        System.out.printf("%.3f",result);
    }
}
