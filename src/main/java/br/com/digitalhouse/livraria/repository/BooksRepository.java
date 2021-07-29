package br.com.digitalhouse.livraria.repository;

import br.com.digitalhouse.livraria.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {

    public Books findBooksByName(String name);
}
