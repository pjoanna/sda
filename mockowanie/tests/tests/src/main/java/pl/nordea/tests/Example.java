package pl.nordea.tests;

import java.util.List;

public class Example {
    public int sum(List<Integer> list){
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }

        return sum;
    }
}
