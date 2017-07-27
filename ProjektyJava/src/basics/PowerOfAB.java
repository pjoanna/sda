package basics;

/**
 * Created by RENT on 2017-07-20.
 */
public class PowerOfAB {
    int a;
    int b;

    public static void main(String[] args) {

    }

    public int pow(int a, int b){
        int pow = 1;
        for (int i = 0; i < b ; i++) {
            pow *= a;
        }
        return pow;
    }


}
