package collection.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by RENT on 2017-07-18.
 */
public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> integers = new LinkedList<>();
        integers.offer(1);
        integers.offer(21);
        integers.offer(2);
        integers.offer(10);
        integers.offer(12);

        System.out.println(integers.peek()); //podglądanie elementu w kolejce

        while (!integers.isEmpty()){
            System.out.println(integers.poll()); //dopóki ktoś stoi wyciągamy elementy
        }

        System.out.println(integers.peek()); //podglądanie elementu w kolejce - teraz w kolejce nic nie ma
    }

}
