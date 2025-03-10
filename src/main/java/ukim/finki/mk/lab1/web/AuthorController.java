package ukim.finki.mk.lab1.web;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.mk.lab1.model.Author;
import ukim.finki.mk.lab1.repository.AuthorRepository;
import ukim.finki.mk.lab1.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> listAll() {
        return authorService.findAll();
    }


    @PostMapping("/add")
    public ResponseEntity<Author> addAuthor(
            @RequestParam String name,
            @RequestParam String surname ,
            @RequestParam Long countryId) {
        return ResponseEntity.ok(authorService.save(name,surname, countryId));
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Author> editAuthor(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam Long countryId) {
        return ResponseEntity.ok(authorService.edit(id, name, surname, countryId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
