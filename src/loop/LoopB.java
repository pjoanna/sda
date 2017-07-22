package loop;

/**
 * Created by RENT on 2017-07-08.
 */
public class LoopB {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            if ((i+1)%2 == 0){
                System.out.println(i+1);
            } else {

            }
        }
        int k=2;
        while(k<=20){
            System.out.println(k);
            k = k+2;
        }
    }
}
