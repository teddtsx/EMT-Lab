package ukim.finki.mk.lab1.service.application;

import ukim.finki.mk.lab1.dto.CreateCountryDto;
import ukim.finki.mk.lab1.dto.UpdateAuthorDto;
import ukim.finki.mk.lab1.dto.UpdateCountryDto;
import ukim.finki.mk.lab1.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    List<UpdateCountryDto> findAll();
    Optional<UpdateCountryDto> findById(Long id);
    Optional <UpdateCountryDto> save(CreateCountryDto createCountryDto);
    Optional <UpdateCountryDto> edit(UpdateCountryDto updateCountryDto);
    void deleteById(Long id);
}
