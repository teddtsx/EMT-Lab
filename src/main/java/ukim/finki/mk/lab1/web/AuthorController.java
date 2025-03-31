package ukim.finki.mk.lab1.web;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.mk.lab1.dto.CreateAuthorDto;
import ukim.finki.mk.lab1.dto.UpdateAuthorDto;
import ukim.finki.mk.lab1.model.domain.Author;
import ukim.finki.mk.lab1.service.domain.AuthorService;

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
}
