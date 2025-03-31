package ukim.finki.mk.lab1.service.domain;

import ukim.finki.mk.lab1.dto.CreateBookDto;
import ukim.finki.mk.lab1.dto.UpdateBookDto;
import ukim.finki.mk.lab1.model.domain.Book;
import ukim.finki.mk.lab1.model.enums.Category;


import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional <Book> save(CreateBookDto createBookDto);
    Optional <Book> edit(UpdateBookDto updateBookDto);
    void deleteById(Long id);
    void markAsTaken(Long id);
   // List<Book> findByNameOrAuthor(String filter);
}
