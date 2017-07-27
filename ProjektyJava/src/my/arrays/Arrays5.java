package my.arrays;

/**
 * Created by RENT on 2017-07-08.
 */
public class Arrays5 {
    public static void main(String[] args) {
        int[][] ones = new int[3][4]; // to są 3 tablice po 4 elementy :P
        // jedna tablica typu int[][], i 3 tablice int[]

        for (int i = 0; i < ones.length; i++) {
            for (int j = 0; j < ones[i].length; j++) {
                ones[i][j] = 1;
            }
        }

        for (int i = 0; i < ones.length; i++) {
            int[] row = ones[i];
            System.out.print("Rząd "+(i+1)+": ");
            for (int j : row){
                System.out.print(ones[i][j]+" ");
            }
            System.out.println();
        }

//        for (int i = 0; i < ones.length; i++) {
//            for (int j = 0; j < ones[i].length; j++) {
//                System.out.print("Rząd "+i+": ");
//                System.out.print(ones[i]);
//            }
//            System.out.println();
//
//        }

    }
}
