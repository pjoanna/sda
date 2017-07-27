package collection.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pjoanna on 2017-07-26.
 */
public class WordMap {
    public static void main(String[] args) {
        String[] words = {"ręka", "noga", "czoło", "brzuch","WATA"};
        Map<Character, Integer> map = new HashMap<>();
        // Dobrze, ale można to trochę skrócić
        map.put('y',2);
        map.put('x',2);
        map.put('h',2);
        map.put('q',2);
        map.put('ą',3);
        map.put('ę',3);
        map.put('ć',3);
        map.put('ł',3);
        map.put('ó',3);
        map.put('ś',3);
        map.put('ż',3);
        map.put('ź',3);
        map.put('a',1);
        map.put('b',1);
        map.put('c',1);
        map.put('d',1);
        map.put('e',1);
        map.put('f',1);
        map.put('g',1);
        map.put('i',1);
        map.put('j',1);
        map.put('k',1);
        map.put('l',1);
        map.put('m',1);
        map.put('n',1);
        map.put('o',1);
        map.put('p',1);
        map.put('r',1);
        map.put('s',1);
        map.put('t',1);
        map.put('u',1);
        map.put('w',1);
        map.put('z',1);



        for (String word : words) {
            String wordHelp = word.toLowerCase();

            Character[] characters = new Character[wordHelp.length()]; // wordHelp.toCharArray()
            for (int i = 0; i < wordHelp.length(); i++) {
                characters[i] = wordHelp.charAt(i);
            }

            int counter = 0;
            for (int i = 0; i < characters.length; i++) { // forEach

                counter += map.get(characters[i]);
            }

            System.out.println("słowo " +word+ " ma wartość " + counter );
        }


    }
}
