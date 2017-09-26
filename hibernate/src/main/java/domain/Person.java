package domain;

import javax.persistence.*;

import java.util.Date;

/**
 * Created by RENT on 2017-09-26.
 */
@Entity
@Table(name = "osoba")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "imie")
    private String name;
    @Column(name = "wiek_osoby")
    private int personAge;
    @Column(name = "wynagrodzenie")
    private double salary;
    @Transient
    private String string1;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Temporal(TemporalType.TIME)
    private Date time;
    @Enumerated(EnumType.ORDINAL) // indexy (od 0) enumów
    private Size size;
    @Enumerated(EnumType.STRING) // nazwy enumów
    private WorkerType workerType;

    public Person() {
    }

    public Person(String name, int personAge, double salary, String string1, Date date, Date time, Size size, WorkerType workerType) {
        this.name = name;
        this.personAge = personAge;
        this.salary = salary;
        this.string1 = string1;
        this.date = date;
        this.time = time;
        this.size = size;
        this.workerType = workerType;
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

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public WorkerType getWorkerType() {
        return workerType;
    }

    public void setWorkerType(WorkerType workerType) {
        this.workerType = workerType;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
