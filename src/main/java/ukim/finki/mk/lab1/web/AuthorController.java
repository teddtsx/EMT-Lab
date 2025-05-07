package ukim.finki.mk.lab1.web;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.mk.lab1.dto.CreateAuthorDto;
import ukim.finki.mk.lab1.dto.UpdateAuthorDto;
import ukim.finki.mk.lab1.model.domain.Author;
import ukim.finki.mk.lab1.projections.AuthorProjection;
import ukim.finki.mk.lab1.repository.AuthorRepository;
import ukim.finki.mk.lab1.service.domain.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorService authorService, AuthorRepository authorRepository) {
        this.authorService = authorService;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public List<Author> listAll() {
        return authorService.findAll();
    }


    @PostMapping("/add")
    public ResponseEntity<Author> addAuthor(CreateAuthorDto createAuthorDto) {
        return ResponseEntity.ok(authorService.save(createAuthorDto).orElseThrow());
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Author> editAuthor(
            UpdateAuthorDto updateAuthorDto) {
        return ResponseEntity.ok(authorService.edit(updateAuthorDto).orElseThrow());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/names")
    public ResponseEntity<List<AuthorProjection>> getAuthorNames() {
        List<AuthorProjection> authorNames = authorRepository.findAuthorProjections();
        return ResponseEntity.ok(authorNames);
    }
}
