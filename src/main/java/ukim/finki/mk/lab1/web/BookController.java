package ukim.finki.mk.lab1.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.mk.lab1.model.Book;
import ukim.finki.mk.lab1.model.enums.Category;
import ukim.finki.mk.lab1.service.BookService;

import java.util.List;

@RestController
@RequestMapping(value = {"/", "/api/books"})
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> listAll() {
        return bookService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(
            @RequestParam String name,
            @RequestParam Category category,
            @RequestParam Long authorId,
            @RequestParam Integer availableCopies) {
        return ResponseEntity.ok(bookService.save(name, category, authorId, availableCopies));
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam Category category,
            @RequestParam Long authorId,
            @RequestParam Integer availableCopies) {
        return ResponseEntity.ok(bookService.edit(id, name, category, authorId, availableCopies));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/rent/{id}")
    public ResponseEntity<Void> markAsRented(@PathVariable Long id) {
        bookService.markAsTaken(id);
        return ResponseEntity.ok().build();
    }
    /*
    @GetMapping("/filter")
    public ResponseEntity<List<Book>> filterByNameOrAuthor(@RequestParam String filter){
        return ResponseEntity.ok(bookService.findByNameOrAuthor(filter));
    }

     */
}