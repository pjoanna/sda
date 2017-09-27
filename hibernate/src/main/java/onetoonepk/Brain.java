package onetoonepk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by RENT on 2017-09-27.
 */
@Entity
public class Brain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int capacity;

    public Brain() {
    }

    public Brain(int capacity) {
        this.capacity = capacity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Brain{" +
                "id=" + id +
                ", capacity=" + capacity +
                '}';
    }
}
