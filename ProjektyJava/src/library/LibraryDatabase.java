package library;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-07-18.
 */
public class LibraryDatabase {
    private List<Book> books = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
}
