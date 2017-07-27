package my.arrays;

/**
 * Created by RENT on 2017-07-10.
 */
public class TwoDimArrayMultiplicationTable {
    public static void main(String[] args) {
        int[][] multiplicationTable = new int[4][4];

        for (int i = 0; i < multiplicationTable.length; i++) {
            for (int j = 0; j < multiplicationTable[i].length; j++) {
                multiplicationTable[i][j] = (i+1)*(j+1);
            }

        }

        for (int i = 0; i < multiplicationTable.length; i++) {
            for (int j = 0; j < multiplicationTable[i].length; j++) {
                System.out.println(multiplicationTable[i][j]);
            }

        }
    }
}
