package ukim.finki.mk.lab1.service.application.Impl;

import ukim.finki.mk.lab1.dto.CreateBookDto;
import ukim.finki.mk.lab1.dto.UpdateBookDto;
import ukim.finki.mk.lab1.service.application.BookApplicationService;
import ukim.finki.mk.lab1.service.domain.AuthorService;
import ukim.finki.mk.lab1.service.domain.BookService;
import ukim.finki.mk.lab1.service.domain.CountryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookApplicationServiceImpl implements BookApplicationService {
    private final BookService bookService;
    private final CountryService countryService;
    private final AuthorService authorService;

    public BookApplicationServiceImpl(BookService bookService, CountryService countryService, AuthorService authorService) {
        this.bookService = bookService;
        this.countryService = countryService;
        this.authorService = authorService;
    }

    @Override
    public List<UpdateBookDto> findAll() {
        return bookService.findAll().stream().map(UpdateBookDto::from).collect(Collectors.toList());
    }

    @Override
    public Optional<UpdateBookDto> findById(Long id) {
        return bookService.findById(id).map(UpdateBookDto::from);
    }

    @Override
    public Optional<UpdateBookDto> save(CreateBookDto createBookDto) {

        return bookService.save(createBookDto).map(UpdateBookDto::from);
    }

    @Override
    public Optional<UpdateBookDto> edit(UpdateBookDto updateBookDto) {
        return bookService.edit(updateBookDto).map(UpdateBookDto::from);
    }

    @Override
    public void deleteById(Long id) {
        bookService.deleteById(id);
    }

    @Override
    public void markAsTaken(Long id) {
        bookService.markAsTaken(id);
    }
}
