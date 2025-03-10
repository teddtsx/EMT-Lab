package ukim.finki.mk.lab1.service;

import ukim.finki.mk.lab1.model.Author;
import ukim.finki.mk.lab1.model.Country;


import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Author save(String name, String surname, Long countryId);
   Author edit(Long id, String name, String surname, Long countryId);
    void deleteById(Long id);
}
