import java.util.Random;

/**
 * Created by RENT on 2017-09-05.
 */
public class BubbleSorter {
    private int[] array;
    public BubbleSorter(int N){
        for (int i = 0; i < N; i++) {
            array[i] = new Random().nextInt(20);
            System.out.print(array[i] + " ");
        }


    }

    public void sort(){
        int n = array.length;
        do {
            for (int i = 0; i < n-1 ; i++) {
                if (array[i] > array[i+1]) {
                    int tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                    n--;
                }
            }
        }while (n>1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
