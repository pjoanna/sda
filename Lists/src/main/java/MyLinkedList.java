/**
 * Created by RENT on 2017-09-04.
 */
public class MyLinkedList {
    private Node root;

    public MyLinkedList() {
        this.root = null;
    }

    public void add(Object object) {
        Node node = new Node(object);

        if (root == null) {
            root = node;
        } else {
            Node tmp = root;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(node);
        }
    }

    public void print() {
        Node tmp = root;
        if (tmp == null) {
            return;
        }

        while (tmp.getNext() != null) {
            System.out.println(tmp.getData());
            tmp = tmp.getNext();
        }
        System.out.println(tmp.getData());
    }

    public void remove() {
        if (root != null) {
            root = root.getNext();
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

    public void add(Object data, int index) {

        if (index == 0){
            Node tmp = new Node(data);
            tmp.setNext(root);
            root = tmp;
            return;
        }

        Node tmp = root;
        Node tmpPrev = root;
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
        int licznik = 0;

        if (root != null) {
            while (tmp.getNext() != null && licznik != index) {
                tmpPrev = tmp;
                tmp = tmp.getNext();
                licznik++;
            }
            tmp = tmp.getNext();
            tmpPrev.setNext(tmp);
        }
    }

    public int size(){
        int counter = 0;
        if (root != null){
            counter+=1;
        }
        Node tmp = root;
        while (tmp.getNext() != null){
            tmp = tmp.getNext();
            counter++;
        }

        return counter;
    }
}

