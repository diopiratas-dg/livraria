package br.com.digitalhouse.livraria.repository;

import br.com.digitalhouse.livraria.model.Library;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class LibraryRepositoryTests {

    @Autowired
    private LibraryRepository libraryRepository;

    @Test
    public void insertBook(){
        Library library = new Library("TDD na Pratica", 87.20, "Digitalsers");
        libraryRepository.save(library);

        Integer countBooks = Math.toIntExact(libraryRepository.findAll().stream().count());
        assertEquals(1, countBooks);
    }
}
