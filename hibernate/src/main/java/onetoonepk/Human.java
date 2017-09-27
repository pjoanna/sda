package onetoonepk;

import javax.persistence.*;

/**
 * Created by RENT on 2017-09-27.
 */
@Entity
public class Human {
    @Id
    private int id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Brain brain;

    public Human() {
    }

    public Human(String name, Brain brain) {
        this.name = name;
        this.brain = brain;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brain getBrain() {
        return brain;
    }

    public void setBrain(Brain brain) {
        this.brain = brain;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brain=" + brain +
                '}';
    }
}
