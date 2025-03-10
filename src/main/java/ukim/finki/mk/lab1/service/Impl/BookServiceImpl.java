package ukim.finki.mk.lab1.service.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.lab1.model.Author;
import ukim.finki.mk.lab1.model.Book;
import ukim.finki.mk.lab1.model.enums.Category;
import ukim.finki.mk.lab1.repository.AuthorRepository;
import ukim.finki.mk.lab1.repository.BookRepository;
import ukim.finki.mk.lab1.service.BookService;

import java.util.List;
import java.util.Optional;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(String name, Category category, Long authorId, Integer availableCopies) {

        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));
        Book book = new Book(name, category, author, availableCopies);
        return bookRepository.save(book);
    }

    @Override
    public Book edit(Long id, String name, Category category, Long authorId, Integer availableCopies) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public void markAsTaken(Long id) {
        Book book= bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not found"));
        if (book.getAvailableCopies()>0){
            book.setAvailableCopies(book.getAvailableCopies()-1);
            bookRepository.save(book);
        }else {
            throw new RuntimeException("No available copies of the book");
        }
    }

 /*   @Override
    public List<Book> findByNameOrAuthor(String filter) {

        List<Book> allbooks = bookRepository.findAll();
        List<Book> filteredBooks = allbooks.stream()
                .filter(book -> book.getName().toLowerCase().contains(filter.toLowerCase()) ||
                        book.getAuthor().getName().toLowerCase().contains(filter.toLowerCase()))
                .toList();

        return List.of();
    }

  */
}
