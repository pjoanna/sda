package library;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RENT on 2017-07-19.
 */
public class HireManager {
    private Map<Reader, Book> hires = new HashMap<>();
    private final LibraryDatabase libraryDatabase;

    public HireManager(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public void hireBook(Reader reader, Book book){
        hires.put(reader, book);
    }

    public void giveAwayBook(Reader reader, Book book){
        hires.remove(reader);
    }

    public boolean isHired(Book book){
        return hires.containsValue(book);
    }

    public Hire getHire(Reader reader){
        return new Hire(reader, hires.get(reader));
    }
}
