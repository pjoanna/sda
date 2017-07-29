package parse.array;

import java.util.List;

/**
 * Created by RENT on 2017-07-29.
 */
public class Statistic {
    public static double mean(List<Integer> list){
        double sum = 0;
        if (list.size() == 0){
            return 0;
        }

        for(int integer : list){
            sum += integer;
        }
        double average = sum/list.size();
        return average;

    }
}
