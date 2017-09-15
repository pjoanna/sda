/**
 * Created by RENT on 2017-09-04.
 */
public class MyLinkedList implements MyCollection{
    private Node root;
    private Node tail;

    public MyLinkedList() {
        this.root = null;
        this.tail = null;
    }

    public void add(Object object) {
        Node node = new Node(object);

        if (root == null) {
            root = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
    }

    public void print() {
        Node tmp = root;
        if (tmp == null) {
            return;
        }

        while (tmp.getNext() != null) {
            System.out.print(tmp.getData() + " ");
            tmp = tmp.getNext();
        }
        System.out.println(tmp.getData());
    }

    public void printFromLast() {
        Node tmp = tail;
        if (tmp == null) {
            return;
        }
        while (tmp.getPrev() != null) {
            System.out.print(tmp.getData() + " ");
            tmp = tmp.getPrev();
        }
        System.out.println(tmp.getData());
    }

    public void remove() {
        if(root == null){
            return;
        }

        if (root == tail){
            root = tail = null;
        }else  {
            root = root.getNext();
            root.setPrev(null);
        }

    }

    public Object get(int index) {
        if (root == null) {
            return null;
        }
        Node tmp = root;

        int licznik = 0;
        while (tmp.getNext() != null && licznik != index) {
            tmp = tmp.getNext();
            licznik++;
        }

        if (licznik == index) {
            return tmp.getData();
        } else {
            System.err.println("niedostateczna liczba elementów");
            return null;
        }
    }

    public void addAtPosition(Object data, int index) {

        if (index == 0){
            Node tmp = new Node(data);
            tmp.setNext(root);
            tmp.setPrev(null);
            root = tmp;
            return;
        }
        if (index == size()){
            Node tmp = new Node(data);
            tmp.setNext(null);
            tmp.setPrev(tail);
            tail = tmp;
            return;
        }

        Node tmp = root;
        Node tmpPrev = root;
        Node tmpTail = tail;
        int licznik = 0;
        if (root != null) {
            while (tmp.getNext() != null && licznik != index) {
                tmpPrev = tmp;
                tmp = tmp.getNext();
                licznik++;
            }

            if (licznik == 1) {
                tmpPrev = null;

            }

            if (licznik == index) {
                Node node = new Node(data);
                tmpPrev.setNext(node);
                node.setNext(tmp);
            } else {
                System.out.println("array of bounds exception");
            }
        }

    }

    public void removeAtPosition(int index) {

        if (index == 0){
            remove();
            return;
        }

        Node tmp = root;
        Node tmpPrev = root;
        Node tmpNext = tail;
        int licznik = 0;

        if (root != null) {
            while (tmp.getNext() != null && licznik != index) {
                tmpPrev = tmp;
                tmp = tmp.getNext();
                licznik++;
            }
            tmp = tmp.getNext();
            tmpPrev.setNext(tmp);
            tmpNext.setPrev(tmp);
        }
    }

    public int size(){
        int counter = 1;
        if (root == null){
            return 0;
        }
        while (root.getNext() != null){
            counter ++;
        }
        return counter;
    }

}

