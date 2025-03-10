package ukim.finki.mk.lab1.service;

import ukim.finki.mk.lab1.model.Book;
import ukim.finki.mk.lab1.model.enums.Category;


import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book save(String name, Category category, Long authorId, Integer availableCopies);
    Book edit(Long id, String name, Category category, Long authorId, Integer availableCopies);
    void deleteById(Long id);
    void markAsTaken(Long id);
   // List<Book> findByNameOrAuthor(String filter);
}
