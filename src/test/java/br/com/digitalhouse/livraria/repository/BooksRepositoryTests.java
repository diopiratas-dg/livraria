package br.com.digitalhouse.livraria.repository;

import br.com.digitalhouse.livraria.model.Books;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BooksRepositoryTests {

    @Autowired
    private BooksRepository booksRepository;

    @Test
    public void insertBook(){
        Books books = new Books("TDD na Pratica", 87.20, "Digitalsers");
        booksRepository.save(books);

        Integer countBooks = Math.toIntExact(booksRepository.findAll().stream().count());
        assertEquals(1, countBooks);
    }

    @Test
    public void checkBookSavedWithName(){
        Books books = new Books("TDD na Pratica", 87.20, "Digitalsers");
        booksRepository.save(books);

        Integer countBooks = Math.toIntExact(booksRepository.findAll().stream().count());
        assertEquals(1, countBooks);

        Books book = booksRepository.findBooksByName("TDD na Pratica");

        assertNotNull(book);
        assertEquals(books, book);
    }

    @Test
    public void checkBookSavedWithNamePassingOtherNameShouldReturnNull(){
        Books books = new Books("TDD na Pratica", 87.20, "Digitalsers");
        booksRepository.save(books);

        Integer countBooks = Math.toIntExact(booksRepository.findAll().stream().count());
        assertEquals(1, countBooks);

        Books book = booksRepository.findBooksByName("100% Javeiro");

        assertNull(book);
    }
}
