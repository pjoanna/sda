/**
 * Created by RENT on 2017-09-05.
 */
public class DoubleLinkedList<V> {
    private Node<V> root; // początek (pierwszy element) listy
    private Node<V> tail; // koniec listy (ostatni element)

    public DoubleLinkedList() {
        this.root = null;
        this.tail = null;
    }

    /**
     * Dodaje element do listy (opakowuje go w węzeł).
     *
     * @param data - dane które mają być dodane do listy.
     */
    public void add(V data) {
        Node<V> wezel = new Node(data);

        if (root == null) { // lista jest pusta
            tail = wezel;
            root = wezel;
        } else { // lista nie jest pusta

            tail.setNext(wezel);
            wezel.setPrev(tail);

            tail = wezel;
        }
    }

    /**
     * Usunięcie elementu (pierwszego z kolejki)
     */
    public void remove() {
        if (root == null) { // nie ma elementów do usuwania.
            return;
        }
        if (root == tail) { // gdy root == tail, oznacza to że jest tylko 1 element
            root = tail = null;
        } else { // gdy jest więcej elementów
            root = root.getNext();
            root.setPrev(null);
        }
    }

    /**
     * Wypisuje całą listę.
     */
    public void print() {
        Node<V> tmp = root;    // przypisz pierwszy element

        // aby nie było nullpointerexception
        if (tmp == null) {
            return;
        }

        System.out.println();
        while (tmp.getNext() != null) { // dopóki istnieje następny element
            System.out.print(tmp.getData() + ", "); // wypisz jego dane
            tmp = tmp.getNext();        // przejdź do następnego elementu
        }
        System.out.print(tmp.getData());
    }

    public void printFromLast() {
        Node<V> tmp = tail;    // przypisz pierwszy element

        // aby nie było nullpointerexception
        if (tmp == null) {
            return;
        }

        System.out.println();
        while (tmp.getPrev() != null) { // dopóki istnieje następny element
            System.out.print(tmp.getData() + ", "); // wypisz jego dane
            tmp = tmp.getPrev();        // przejdź do następnego elementu
        }
        System.out.print(tmp.getData());
    }

    /**
     * @param data
     * @param index
     */
    public void add(V data, int index) {
        Node<V> wezel = new Node(data);

        int licznik = 0;
        Node<V> tmp = root;    // przechodzimy do n-tego elementu
        Node<V> tmpPrev = null; // poprzedni element od tmp
        while (tmp.getNext() != null && licznik != index) { // dopóki istnieje następny element
            tmpPrev = tmp;  // poprzedni element to tmp, tmp to next
            tmp = tmp.getNext();        // przejdź do następnego elementu
            licznik++; // inkrementacja licznika
        }

        if (tmpPrev == null) { // wstawiamy zamiast root'a (czyli jako 1 element)
//            add(data);
//            return;
            wezel.setNext(root);
            root.setPrev(wezel);
            root = wezel;
        } else if (licznik == index) { // dotarliśmy do n-tego elementu
            wezel.setNext(tmp); // 2

            tmpPrev.setNext(wezel); //1
            tmp.setPrev(wezel); // 3
            wezel.setPrev(tmpPrev); // 4

        } else if (tmp.getNext() == null && (licznik + 1) == index) { // wstawiamy na ost. indeks
            tail.setNext(wezel);
            // ^^ gdy jest jednokierunkowa
            wezel.setPrev(tail);
            tail = wezel; // ustaw tail
        } else {
            System.out.println("nie moge dodac elementu, arrayindexoutofbounds");
        }
    }

    /**
     * Zwraca n-ty element listy.
     *
     * @param index - numer elementu.
     * @return n-ty element listy.
     */
    public V get(int index) {
        if (root == null) { // gdy lista jest pusta
            return null; // zwróć null
        }

        int licznik = 0;
        Node<V> tmp = root;
        while (tmp.getNext() != null && licznik != index) { // dopóki istnieje następny element
            tmp = tmp.getNext();        // przejdź do następnego elementu
            licznik++; // inkrementacja licznika
        }

        if (licznik == index) { // dotarliśmy do n-tego elementu
            return tmp.getData(); // zwracamy n-ty element
        } else { // wypadliśmy z pętli ponieważ nie ma dostatecznej ilości elementów
            System.out.println("Niedostateczna ilość elementów");
            return null;
        }
    }

    /**
     * Usuwa element na pozycji.
     *
     * @param index - indeks usuwanego elementu.
     */
    public void removeAtPosition(int index) {
        if (index == 0) { // uproszczony przypadek usunięcia 1 elementu listy
            remove();
            return; // powrót
        }

        int licznik = 0;
        Node<V> tmp = root;    // przechodzimy do n-tego elementu
        Node<V> tmpPrev = null; // poprzedni element od tmp
        while (tmp.getNext() != null && licznik != index) { // dopóki istnieje następny element
            tmpPrev = tmp;  // poprzedni element to tmp, tmp to next
            tmp = tmp.getNext();        // przejdź do następnego elementu
            licznik++; // inkrementacja licznika
        }

        if (licznik == index) {
            // ustaw next z pominięciem następnego elementu.
            tmpPrev.setNext(tmp.getNext()); // 1
            if (tmp.getNext() != null) { // gdy usuwamy NIE ostatni element
                tmp.getNext().setPrev(tmpPrev); // 2
            }
            if (tmp == tail) { // usuwamy ostatni element
                tail = tmpPrev;
            }
        }
    }

    /**
     * Zwraca ilość elementów w liście.
     *
     * @return ilość elementów w liście.
     */
    public int size() {
        if (root == null) {
            return 0;
        }

        int licznik = 1;    // fakt że jest root, powoduje że licznik = 1
        Node<V> tmp = root;    // przechodzimy do n-tego elementu
        while (tmp.getNext() != null) { // dopóki istnieje następny element
            tmp = tmp.getNext();        // przejdź do następnego elementu
            licznik++; // inkrementacja licznika
        }

        return licznik;         // licznik skoków pomiędzy elementami
    }
}
