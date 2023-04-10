package com.brindha.oms.Repotests;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;
import com.brindha.oms.model.Book;
import com.brindha.oms.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepoTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testSaveBook() {

        Book book = new Book("2states", "A love story", 2009, "fiction");


        Book savedInDb = entityManager.persist(book);
        Optional<Book> getFromDb = bookRepository.findById(savedInDb.getId());
        assertThat(getFromDb).isEqualTo(Optional.of(savedInDb));


    }


}