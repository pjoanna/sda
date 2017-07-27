package collection.maps;

import java.util.HashMap;
import java.util.Map;
//HashMap wyświetla losowo; TreeMap sortuje wg klucza
/**
 * Created by RENT on 2017-07-17.
 */
public class MapExample {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 2);
        map.put('ź', 5);
        map.put('ź', 8); // to jest swego rodzaju zbiór - 5 zostaje nadpisana przez 8 dla klucza 'ź'
        map.put('ź', null); // można tu wpisać null !

        System.out.println("Rozmiar: " + map.size());

        System.out.println("Key a " + map.containsKey('a'));
        System.out.println("Key c " + map.containsKey('c'));
        System.out.println("Value 3 " + map.containsValue(3));
        System.out.println("Value 5 " + map.containsValue(5));


        System.out.println(map.keySet());
        System.out.println(map.values());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) { // para z mapy
            System.out.println(entry.getKey() + "->"+ entry.getValue());
        }
        System.out.println("Value of a "+map.get('a'));
        System.out.println("Value of r "+map.get('r'));
        System.out.println("Value of r "+map.getOrDefault('r', 9));
        System.out.println("Value of a "+map.getOrDefault('a', 9));
        System.out.println("null "+map.get(1));


        map.remove('a', 3); // nie istniał taaki element więc nic się nie dzieje
        map.remove('b'); //usuwa element który był w mapie
        map.remove('a', 1); //usuwa element który był w mapie

        map.clear(); // czyści całą mapę

    }
}
