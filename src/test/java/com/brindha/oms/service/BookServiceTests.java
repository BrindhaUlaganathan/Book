package com.brindha.oms.service;
import static org.assertj.core.api.Assertions.assertThat;
import com.brindha.oms.model.Book;
import com.brindha.oms.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTests {

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void testCreateBook() {
        Book book = new Book();
        book.setId(354);
        book.setName("2 states");
        book.setDescription("A love story");
        book.setYearOfPublication(2009);
        book.setBookType("fiction");

        Mockito.when(bookRepository.save(book)).thenReturn(book);
        assertThat(bookService.createBook(book)).isEqualTo(book);

    }
}