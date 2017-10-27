package pl.nordea.tests.bookstore.facade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.nordea.tests.bookstore.book.Book;
import pl.nordea.tests.bookstore.book.BookRepository;
import pl.nordea.tests.bookstore.remote.NotEnoughMoneyException;
import pl.nordea.tests.bookstore.remote.PaymentService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookStoreServiceTest {
    @Mock
    private ISBNDto isbnDto;
    @Mock
    private ClientDto clientDto;
    @Mock
    private BookRepository bookRepository;
    @Mock
    private PaymentService paymentService;
    @Mock
    private Book book;

    @InjectMocks
    private BookStoreService sut = new BookStoreService();

    private String isbn = "1234";
    private long cardId = 90909L;
    private double price = 45.99;


    @Test
    public void shouldReturnBookNotFoundIfBookDoNotExists() throws Exception {
        // given
        when(isbnDto.getIsbn()).thenReturn(isbn);
        when(bookRepository.find(isbnDto.getIsbn())).thenReturn(Optional.empty());


        // when
        ResultDto actual = sut.buy(isbnDto, clientDto);

        // then
        assertThat(actual.getStatus()).isEqualTo(ResultDto.Status.BOOK_NOT_FOUND);
        assertThat(actual.getMessage()).isEqualTo(("Book isbn: " + isbn + " not found"));
        assertThat(actual.getBookDtos()).isEmpty();

        verify(bookRepository, Mockito.times(1)).find(isbn);
        verify(paymentService, Mockito.never()).pay(anyLong(), anyDouble());
    }

    @Test
    public void shouldReturnPaymentErrorIfNotEnoughMoney() throws Exception {
        // given
        when(isbnDto.getIsbn()).thenReturn(isbn);
        when(bookRepository.find(isbn)).thenReturn(Optional.of(book));
        when(clientDto.getCardId()).thenReturn(cardId);
        when(book.getPrice()).thenReturn(price);

        String message = "You do not have $" + price;
        doThrow(new NotEnoughMoneyException(message)).when(paymentService).pay(cardId, price);

        // when
        ResultDto actual = sut.buy(isbnDto, clientDto);

        // then
        assertThat(actual.getStatus()).isEqualTo(ResultDto.Status.PAYMENT_ERROR);
        assertThat(actual.getMessage()).isEqualTo(message);
        assertThat(actual.getBookDtos()).isEmpty();


        verify(bookRepository).find(isbn);
        verify(paymentService).pay(cardId, price);
    }
}