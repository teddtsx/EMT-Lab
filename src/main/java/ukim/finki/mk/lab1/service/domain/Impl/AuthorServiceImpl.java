package ukim.finki.mk.lab1.service.domain.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.lab1.dto.CreateAuthorDto;
import ukim.finki.mk.lab1.dto.UpdateAuthorDto;
import ukim.finki.mk.lab1.model.domain.Author;
import ukim.finki.mk.lab1.model.domain.Country;
import ukim.finki.mk.lab1.repository.AuthorRepository;
import ukim.finki.mk.lab1.repository.CountryRepository;
import ukim.finki.mk.lab1.service.domain.AuthorService;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }



    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional <Author> save(CreateAuthorDto createAuthorDto) {
        Country country = countryRepository.findById(createAuthorDto.country()).orElseThrow(()->new RuntimeException("Country not found"));
        Author  author=new Author(createAuthorDto.name(),createAuthorDto.surname(),country);
        return Optional.of(authorRepository.save(author)) ;
    }

    @Override
    public Optional <Author> edit(UpdateAuthorDto updateAuthorDto) {
        Author author=authorRepository.findById(updateAuthorDto.id()).orElseThrow(()->new RuntimeException("Author not found"));
        Country country=countryRepository.findById(updateAuthorDto.country()).orElseThrow(()->new RuntimeException("Country not found"));
        author.setName(updateAuthorDto.name());
        author.setSurname(updateAuthorDto.surname());
        author.setCountry(country);
        return Optional.of(authorRepository.save(author));
    }

    @Override
    public void deleteById(Long id) {
    authorRepository.deleteById(id);
    }
}
