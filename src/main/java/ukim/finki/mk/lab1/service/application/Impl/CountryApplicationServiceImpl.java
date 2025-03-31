package ukim.finki.mk.lab1.service.application.Impl;

import ukim.finki.mk.lab1.dto.CreateCountryDto;
import ukim.finki.mk.lab1.dto.UpdateCountryDto;
import ukim.finki.mk.lab1.repository.BookRepository;
import ukim.finki.mk.lab1.service.application.CountryApplicationService;
import ukim.finki.mk.lab1.service.domain.AuthorService;
import ukim.finki.mk.lab1.service.domain.BookService;
import ukim.finki.mk.lab1.service.domain.CountryService;

import java.util.List;
import java.util.Optional;

public class CountryApplicationServiceImpl implements CountryApplicationService {
    private final CountryService countryService;
    private final BookService bookService;
    private final AuthorService authorService;

    public CountryApplicationServiceImpl(CountryService countryService, BookService bookService, AuthorService authorService) {
        this.countryService = countryService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public List<UpdateCountryDto> findAll() {
        return UpdateCountryDto.from(countryService.findAll());
    }

    @Override
    public Optional<UpdateCountryDto> findById(Long id) {
        return countryService.findById(id).map(UpdateCountryDto::from);
    }

    @Override
    public Optional<UpdateCountryDto> save(CreateCountryDto createCountryDto) {
        return countryService.save(createCountryDto).map(UpdateCountryDto::from);
    }

    @Override
    public Optional<UpdateCountryDto> edit(UpdateCountryDto updateCountryDto) {
        return countryService.edit(updateCountryDto).map(UpdateCountryDto::from);
    }

    @Override
    public void deleteById(Long id) {
        countryService.deleteById(id);
    }
}
