package middle;

/**
 * Created by RENT on 2017-07-11.
 */
public class ArrayCopy {
    public static void main(String[] args) {
        int[] numbers = {2,2,3};
        int[] copyTab;
        copyTab = copyOfArray(numbers);

        for(int number : copyTab){
            System.out.println(number);
        }

    }
    public static int[] copyOfArray(int[] tab){
        int[] myCopy = new int[tab.length];
        for (int i = 0; i < tab.length; i++) {
            myCopy[i] = tab[i];
        }
        return myCopy;
    }
}
