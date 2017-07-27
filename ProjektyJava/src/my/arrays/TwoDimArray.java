package my.arrays;

/**
 * Created by RENT on 2017-07-10.
 */
public class TwoDimArray {
    public static void main(String[] args) {
        int[][] myArray = new int[4][4];
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                myArray[i][j] = i*myArray[i].length+j+1;
            }

        }

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                System.out.print(myArray[i][j]+" ");
            }
            System.out.println();
        }
    }

}
