package my.arrays;

/**
 * Created by RENT on 2017-07-08.
 */
public class Array1 {
    public static void main(String[] args) {
        int[] numbers = {1,3,5,10};

        for(int number : numbers){
            System.out.println(number);
        }
        for (int i = numbers.length-1; i >= 0; i--) {
            System.out.println(numbers[i]);
        }

        for (int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }

    }
}
