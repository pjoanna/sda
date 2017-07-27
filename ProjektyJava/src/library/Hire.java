package library;

import library.Book;
import library.Reader;

/**
 * Created by pjoanna on 2017-07-20.
 */
public class Hire {
    private Reader reader;
    private Book book;

    public Hire(Reader reader, Book book) {

        this.reader = reader;
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }
}