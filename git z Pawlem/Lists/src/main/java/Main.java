/**
 * Created by RENT on 2017-09-04.
 */
public class Main {
    public static void main(String[] args) {
        MyCollection list = new MyArrayList();
        list.add(23);
        list.add(2);
        list.add(4);
        list.add(3);

        list.print();
//        list.remove();
//        System.out.println();
//        list.print();
//        System.out.println();
//        System.out.println(list.get(1));
//       System.out.println(list.get(4));
//        list.add(234, 2);
        System.out.println();
        list.print();
//        list.add(11, 0);
//        System.out.println();
//        list.print();

        list.removeAtPosition(1);
        System.out.println();
        list.print();

 //       list.printFromLast();
    }
}
