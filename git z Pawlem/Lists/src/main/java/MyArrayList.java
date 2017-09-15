/**
 * Created by RENT on 2017-09-05.
 */
public class MyArrayList<V extends Object> implements MyCollection<V> {

    private final static int ARRAY_SIZE = 25000;

    private V[] array;
    private int objectCounter; // do zliczania ilości elementów w liście

    public MyArrayList() {
        array = (V[]) new Object[ARRAY_SIZE];
        objectCounter = 0;
    }

    public void add(V data) {
        if (objectCounter < array.length) { // mamy miejsce
            array[objectCounter] = data; // umieszczamy element
            objectCounter++;                // zwiększamy licznik
        } else { //
            V[] newArray = (V[]) new Object[ARRAY_SIZE + array.length]; //alokujemy nową pamięć
            for (int i = 0; i < array.length; i++) { // przepisujemy stare elementy
                newArray[i] = array[i];
            }

            newArray[objectCounter] = data; // dodajemy nowy element
            objectCounter++;    // zwiększamy licznik
            array = newArray;   // ustawiamy nową
        }
    }

    public void remove() {
        if (objectCounter > 0) { // są elementy
            objectCounter--;
        }
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < objectCounter; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    public void printFromLast() {
        System.out.println();
        for (int i = objectCounter - 1; i >= 0; i--) {
            System.out.print(array[i] + ", ");
        }
    }

    public void add(V data, int index) {

        if (objectCounter >= array.length) { // brakuje mi miejsca
            // jeśli brakuje miejsca, tablicę trzeba rozszerzyć
            V[] newArray = (V[]) new Object[ARRAY_SIZE + array.length]; //alokujemy nową pamięć
            for (int i = 0; i < array.length; i++) { // przepisujemy stare elementy
                newArray[i] = array[i];
            }
            array = newArray; // nowa rozszerzona tablica
        }

        for (int i = objectCounter - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = data;
        objectCounter++;
    }

    public V get(int index) {
        if (index >= 0 && index < objectCounter) { // sprawdzamy czy jesteśmy w zakresie
            return array[index]; // zwracamy wartość
        }

        throw new ArrayIndexOutOfBoundsException(); // jeśli wykroczymy
    }

    public void removeAtPosition(int index) {
        for (int i = index; i < objectCounter; i++) { // rozpoczynam od elementu który chcę usunąć
            array[i] = array[i + 1]; // przesuwam elementy (shift)
        }
        objectCounter--; // zmniejszam licznik
    }

    public int size() {
        return objectCounter;
    }
}
