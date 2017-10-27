package pl.nordea.tests.bookstore.facade;

import pl.nordea.tests.bookstore.book.Book;
import pl.nordea.tests.bookstore.book.BookMapper;
import pl.nordea.tests.bookstore.book.BookRepository;
import pl.nordea.tests.bookstore.common.Mapper;
import pl.nordea.tests.bookstore.remote.NotEnoughMoneyException;
import pl.nordea.tests.bookstore.remote.PaymentService;

import java.util.Optional;

public class BookStoreService implements BookStore {

    private BookRepository bookRepository;
    private PaymentService paymentService;

    private Mapper<Book,BookDto> mapper = new BookMapper();

    @Override
    public ResultDto buy(ISBNDto isbn, ClientDto clientDto) {
        // 1 szukanie ksiazki
        // 1a. jesli nie ma ksiazki zwracamy odp ze statuusem
        Optional<Book> bookOptional = bookRepository.find(isbn.getIsbn());
        if (!bookOptional.isPresent()){
            return ResultDto.ofBookNotFound("Book isbn: " + isbn.getIsbn() + " not found");
        }
        Book book = bookOptional.get();

        // 1b. znaleziona - płacimy
        long cardId = clientDto.getCardId();

        try {
            paymentService.pay(cardId, book.getPrice());
        } catch (NotEnoughMoneyException e) {
            // jesli się nie udało zapłacić zwracamy status

            return ResultDto.ofPaymentError(e.getMessage());
        }

        // jak udało się kupić i zapłacić
        BookDto bookDto = mapper.map(book);
        return ResultDto.ofSuccess(bookDto);
    }

}
