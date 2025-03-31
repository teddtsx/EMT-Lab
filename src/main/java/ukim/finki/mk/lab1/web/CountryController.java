package ukim.finki.mk.lab1.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.mk.lab1.dto.CreateCountryDto;
import ukim.finki.mk.lab1.dto.UpdateCountryDto;
import ukim.finki.mk.lab1.model.domain.Country;
import ukim.finki.mk.lab1.service.domain.CountryService;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> listAll() {
        return countryService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Country> addCountry(
            CreateCountryDto createCountryDto) {
        return ResponseEntity.ok(countryService.save(createCountryDto).orElseThrow());
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> editCountry(
            UpdateCountryDto updateCountryDto) {
        return ResponseEntity.ok(countryService.edit(updateCountryDto).orElseThrow());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        countryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}