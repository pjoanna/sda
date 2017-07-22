package library;

import java.util.Random;

/**
 * Created by RENT on 2017-07-19.
 */

public class DataGenerator {
    private String[] names = {"name0", "name1", "name2", "name3", "name4", "name5", "name6", "name7"};
    private String[] surnames = {"surname0", "surname1", "surname2", "surname3", "surname4", "surname5", "surname6", "surname7"};
    private String[] titles = {"title0", "title1", "title2", "title3", "title4", "title5", "title6", "title7"};
    private Random randomData = new Random();

    private int random(){
        return randomData.nextInt(8);
    }

    private String getName(){
        int i = Math.abs(random());
        return names[i];
    }

    private String getSurname(){
        int i = random();
        return surnames[i];
    }

    private String getTitle(){
        int i = random();
        return titles[i];
    }

    public Book book(){
        Book book = new Book(getTitle(), randomData.nextLong());
        return book;
    }

    public Reader reader(){
        Reader reader = new Reader(getName(), getSurname());
        return reader;
    }
}
