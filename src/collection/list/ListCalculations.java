package collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-07-15.
 */
public class ListCalculations {

    public static double sum (List<Double> numbers){
        double result = 0;
        for (Double number : numbers) {
            result += number.doubleValue();
        }
        System.out.println(result);
        return result;
    }
    public static double product (List<Double> numbers){
        double result = 1;
        for (Double number : numbers) {
            result *= number.doubleValue();
        }
        System.out.println(result);
        return result;
    }
    public static double avg (List<Double> numbers){
        double result = 0;
        result = sum(numbers)/numbers.size();
        System.out.println(result);
        return result;
    }

    public static List<Boolean> negative(List<Boolean> numbers){
        List<Boolean> myList = new ArrayList<>();
        for (Boolean number : numbers) {
            myList.add(!number);
        }
        return myList;
    }

    public static boolean conjuction(List<Boolean> numbers){
        boolean value = true;
        for (Boolean number : numbers) {
            value = value && number;
        }
        return value;
    }
    public static boolean alternative(List<Boolean> numbers){
        boolean value = false;
        for (Boolean number : numbers) {
            value = value || number;
        }
        return value;
    }

    public static boolean conjuction2(List<Boolean> numbers){

        for (Boolean number : numbers) {
            if (!number) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(5.0);
        doubleList.add(3.0);
        doubleList.add(-1.0);
        doubleList.add(1.0);

        sum(doubleList);
        product(doubleList);


    }
}
