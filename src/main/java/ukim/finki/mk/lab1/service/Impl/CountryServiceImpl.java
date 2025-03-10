package ukim.finki.mk.lab1.service.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.lab1.model.Country;
import ukim.finki.mk.lab1.repository.CountryRepository;
import ukim.finki.mk.lab1.service.CountryService;

import java.util.List;
import java.util.Optional;
@Service
public class CountryServiceImpl implements CountryService {
    public final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country save(String name, String continent) {
        return countryRepository.save(new Country(name, continent));
    }

    @Override
    public Country edit(Long id, String name, String continent) {

        Country country = countryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
        country.setName(name);
        country.setContinent(continent);
        return countryRepository.save(country);
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
