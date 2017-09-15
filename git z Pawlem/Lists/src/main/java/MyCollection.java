/**
 * Created by RENT on 2017-09-05.
 */
public interface MyCollection<V>  {
        void add(V data);
        void remove();
        void print();
        void printFromLast();
        void add(V data, int index);
        V get(int index);
        void removeAtPosition(int index);
        int size();
}
