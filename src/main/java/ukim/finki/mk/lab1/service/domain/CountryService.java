package ukim.finki.mk.lab1.service.domain;

import ukim.finki.mk.lab1.dto.CreateCountryDto;
import ukim.finki.mk.lab1.dto.UpdateCountryDto;
import ukim.finki.mk.lab1.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Optional <Country> save(CreateCountryDto createCountryDto);
    Optional <Country> edit(UpdateCountryDto updateCountryDto);
    void deleteById(Long id);
}
