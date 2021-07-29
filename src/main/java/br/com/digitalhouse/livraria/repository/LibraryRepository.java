package br.com.digitalhouse.livraria.repository;

import br.com.digitalhouse.livraria.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
}
