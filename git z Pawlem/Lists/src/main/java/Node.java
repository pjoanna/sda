/**
 * Created by RENT on 2017-09-04.
 */
public class Node<Val> {
    private Val data;
    private Node next;
    private Node prev;

    public Node(Val data) {
        this.data = data;
    }

    public Val getData() {
        return data;
    }

    public void setData(Val data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
