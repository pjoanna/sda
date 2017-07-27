package oop;

/**
 * Created by RENT on 2017-07-12.
 */
public class Person {
    private String name;
    private int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Person jan = new Person("Jan", 45);
        Person eryk = new Person("Eryk", 34);
        Person ela = new Person("Ela", 56);

        print(jan);
        print(eryk);
        print(ela);

        jan.print();
        ela.print();
        eryk.print();

    }
    public static void print(Person person){
        System.out.println("Jestem "+person.getName()+", mam "+person.getAge()+" lat");
    }
    public void print(){
        System.out.println("Jestem "+this.getName()+", mam "+getAge()+" lat"); //jeżeli nie ma dwuznaczności nie ma konieczności stosowania this.
    }
}
