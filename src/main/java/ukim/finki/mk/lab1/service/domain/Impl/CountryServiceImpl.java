package ukim.finki.mk.lab1.service.domain.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.lab1.dto.CreateCountryDto;
import ukim.finki.mk.lab1.dto.UpdateCountryDto;
import ukim.finki.mk.lab1.model.domain.Country;
import ukim.finki.mk.lab1.repository.CountryRepository;
import ukim.finki.mk.lab1.service.domain.CountryService;

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
    public Optional <Country> save(CreateCountryDto createCountryDto) {
        return Optional.of(countryRepository.save(new Country(createCountryDto.name(), createCountryDto.continent()))) ;
    }

    @Override
    public Optional <Country> edit(UpdateCountryDto updateCountryDto) {

        Country country = countryRepository.findById(updateCountryDto.id()).orElseThrow(() -> new RuntimeException("Country not found"));
        country.setName(updateCountryDto.name());
        country.setContinent(updateCountryDto.continent());
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
