package collection.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by pjoanna on 2017-07-26.
 */
public class PrimeNumberMap {


    public static boolean primeNumber(int number){
        if (number == 1){
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number%(i) == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Map<Integer, Boolean> primeNumberMap = new HashMap<>();
        for (int i = 1; i <= 30; i++) {
            primeNumberMap.put(i, primeNumber(i));
        }

        for (Map.Entry<Integer, Boolean> integerBooleanEntry : primeNumberMap.entrySet()) {
            if (integerBooleanEntry.getValue()){
                System.out.println(integerBooleanEntry.getKey() + " jest pierwszą liczbą (" + integerBooleanEntry.getValue()+")");
            }
        }

        System.out.println(primeNumberMap.get(1));  //get(KeyType key);
        System.out.println(primeNumberMap.get(4));
        System.out.println(primeNumberMap.get(5));
        System.out.println(primeNumberMap.get(7));
        System.out.println(primeNumberMap.get(9));
        System.out.println(primeNumberMap.get(12));



    }


}
