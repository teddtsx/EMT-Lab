package ukim.finki.mk.lab1.service.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.lab1.model.Author;
import ukim.finki.mk.lab1.model.Country;
import ukim.finki.mk.lab1.repository.AuthorRepository;
import ukim.finki.mk.lab1.repository.CountryRepository;
import ukim.finki.mk.lab1.service.AuthorService;

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
    public Author save(String name, String surname, Long countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(()->new RuntimeException("Country not found"));
        Author  author=new Author(name,surname,country);
        return authorRepository.save(author);
    }

    @Override
    public Author edit(Long id, String name, String surname, Long countryId) {
        Author author=authorRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Author does not exist"));
        Country country=countryRepository.findById(countryId)
                .orElseThrow(()->new RuntimeException("Country not found"));
        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);

        return authorRepository.save(author);
    }

    @Override
    public void deleteById(Long id) {
    authorRepository.deleteById(id);
    }
}
