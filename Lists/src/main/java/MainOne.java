/**
 * Created by RENT on 2017-09-04.
 */
public class MainOne {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(23);
        list.add(2);
        list.add(4);
        list.add(3);
        System.out.println("Rozmiar: " + list.size());

        list.print();
        list.remove();
        System.out.println();
        System.out.println("Rozmiar: " + list.size());
        list.print();
        System.out.println();
        System.out.println(list.get(1));
        System.out.println(list.get(4));
        list.add(234, 2);
        System.out.println();
        list.print();
        list.add(23455, 0);
        System.out.println();
        list.print();
        System.out.println("Rozmiar: " + list.size());

        list.removeAtPosition(0);
        System.out.println();
        list.print();
        System.out.println("Rozmiar: " + list.size());

    }
}
