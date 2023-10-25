package book;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookServiceTest {

    @Test
    public void testGetAllBooks() {
        // Создаем мок-объект BookRepository
        BookRepository bookRepository = Mockito.mock(BookRepository.class);

        // Создаем список книг для возврата из мок-объекта
        List<Book> expectedBooks = Arrays.asList(
                new Book("1234567890", "Java Programming", "John Doe"),
                new Book("0987654321", "Python for Beginners", "Jane Smith")
        );

        // Настраиваем мок-объект для возврата списка книг при вызове метода getAllBooks()
        Mockito.when(bookRepository.getAllBooks()).thenReturn(expectedBooks);

        // Создаем объект BookService с использованием мок-объекта
        BookService bookService = new BookService(bookRepository);

        // Вызываем метод getAllBooks() и проверяем, что он возвращает ожидаемый список книг
        List<Book> actualBooks = bookService.getAllBooks();
        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    public void testGetBookByISBN() {
        // Создаем мок-объект BookRepository
        BookRepository bookRepository = Mockito.mock(BookRepository.class);

        // Создаем книгу для возврата из мок-объекта
        Book expectedBook = new Book("1234567890", "Java Programming", "John Doe");

        // Настраиваем мок-объект для возврата книги при вызове метода getBookByISBN() с указанным ISBN
        Mockito.when(bookRepository.getBookByISBN("1234567890")).thenReturn(expectedBook);

        // Создаем объект BookService с использованием мок-объекта
        BookService bookService = new BookService(bookRepository);

        // Вызываем метод getBookByISBN() с указанным ISBN и проверяем, что он возвращает ожидаемую книгу
        Book actualBook = bookService.getBookByISBN("1234567890");
        assertEquals(expectedBook, actualBook);
    }
}