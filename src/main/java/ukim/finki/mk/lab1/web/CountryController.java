package ukim.finki.mk.lab1.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.mk.lab1.model.Country;
import ukim.finki.mk.lab1.service.CountryService;

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
            @RequestParam String name,
            @RequestParam String continent) {
        return ResponseEntity.ok(countryService.save(name,continent));
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> editCountry(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String continent) {
        return ResponseEntity.ok(countryService.edit(id, name, continent));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        countryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}