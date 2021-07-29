package br.com.digitalhouse.livraria.controller;

import br.com.digitalhouse.livraria.model.Books;
import br.com.digitalhouse.livraria.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksRepository booksRepository;

    @GetMapping(value = "/list")
    @ResponseBody
    public List<Books> findBooks(){
        return booksRepository.findAll();
    }

    @RequestMapping(value = "/list/search", method = RequestMethod.GET)
    public Books listById(@RequestParam Integer id){
        Optional<Books> books = booksRepository.findById(id);

        return books.get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addCategory(@RequestBody Books book){ booksRepository.save(book); }
}
