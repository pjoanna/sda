package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RENT on 2017-07-18.
 */
public class LibraryMain {
    public static void main(String[] args) {
        DataGenerator dataGenerator = new DataGenerator();

        LibraryDatabase libraryDatabase = new LibraryDatabase();
        for (int i = 0; i < 10; i++) {
            libraryDatabase.addBook(dataGenerator.book());
            libraryDatabase.addReader(dataGenerator.reader());
        }

        HireManager hireManager = new HireManager(libraryDatabase);
        hireManager.hireBook(dataGenerator.reader(), dataGenerator.book());

        hireManager.hireBook(dataGenerator.reader(), dataGenerator.book());



//        for (Map.Entry<Reader, Book> hire : hires.entrySet()) {
//            System.out.println("Czytelnik "+hire.getKey().getName()+" wypożyczył(a) książkę "+ hire.getValue().getTitle());
//        }
//
//        hires.remove(readers.get(1)); //  czytelnik oddaje książkę
//
//        System.out.println("a teraz :");
//        for (Map.Entry<Reader, Book> hire : hires.entrySet()) {
//            System.out.println("Czytelnik "+hire.getKey().getName()+" wypożyczył(a) książkę "+ hire.getValue().getTitle());
//        }

    }
}
