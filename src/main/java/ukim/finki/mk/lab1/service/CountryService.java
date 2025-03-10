package ukim.finki.mk.lab1.service;

import ukim.finki.mk.lab1.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Country save(String name, String continent);
    Country edit(Long id, String name, String continent);
    void deleteById(Long id);
}
