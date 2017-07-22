package loop;

/**
 * Created by RENT on 2017-07-08.
 */
public class LoopC {
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            if (((i+1)%3 == 0) || ((i+1)%5 == 0)){
//                System.out.println(i+1);
//            }
//
//        }
        int k = 1;
        while(k <= 100){
            if ((k%3 == 0) || (k%5 == 0)) {
                System.out.println(k);
            }
            k++;
        }
    }
}
