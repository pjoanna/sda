package collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pjoanna on 2017-07-20.
 */
public class Sentence {
    public static void main(String[] args) {
        System.out.println("Napisz jakieś zdanie");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.next();
        String[] words = sentence.split(" ");

        List<String> wordsList = new ArrayList<>();

        for (String word : words) {
            wordsList.add(word);
        }



    }
}
