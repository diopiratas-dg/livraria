package br.com.digitalhouse.livraria.controller;

import br.com.digitalhouse.livraria.model.Books;
import br.com.digitalhouse.livraria.repository.BooksRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = BooksController.class)
public class BooksControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BooksRepository booksRepository;

    @Test
    public void findAllBooksShouldReturnOk() throws Exception{
        List<Books> booksList = new ArrayList<>();

        Books book = new Books("TDD na Pratica", 87.1, "Digitalsers");
        booksList.add(book);

        Books book2 = new Books("Agora vai no TDD", 12.4, "Housers");
        booksList.add(book2);
        when(booksRepository.findAll()).thenReturn(booksList);
        this.mockMvc.perform(
                get("/books/list")
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$[0].name").value("TDD na Pratica"))
                        .andExpect(jsonPath("$[1].name").value("Agora vai no TDD"));
    }

    @Test
    public void findBookByIdShouldReturnOk() throws Exception {
        Books book = new Books("Agora vai no TDD", 12.4, "Housers");
        Mockito.when(booksRepository.save(book)).thenReturn(book);
        this.mockMvc.perform(
                get("/books/list/search")
                        .queryParam("id","1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                 .andExpect(jsonPath("$.name").value("TDD na Pratica"));
    }

    @Test
    public void addBookShouldReturnOk() throws Exception {
        Books book = new Books("CP5Andar", 120.87, "5A/DH");
        Mockito.when(booksRepository.save(book)).thenReturn(book);
        this.mockMvc.perform(
                post("/books/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(book)))
                        .andExpect(status().isCreated());
    }
}
