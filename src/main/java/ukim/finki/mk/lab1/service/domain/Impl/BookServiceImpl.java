package ukim.finki.mk.lab1.service.domain.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.lab1.dto.CreateBookDto;
import ukim.finki.mk.lab1.dto.UpdateAuthorDto;
import ukim.finki.mk.lab1.dto.UpdateBookDto;
import ukim.finki.mk.lab1.model.domain.Author;
import ukim.finki.mk.lab1.model.domain.Book;
import ukim.finki.mk.lab1.model.enums.Category;
import ukim.finki.mk.lab1.repository.AuthorRepository;
import ukim.finki.mk.lab1.repository.BookRepository;
import ukim.finki.mk.lab1.service.domain.BookService;

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

    //  @Override
            //  public Optional <Book> save(CreateBookDto createBookDto) {
        //
        //      Author author = authorRepository.findById(createBookDto.author()).orElseThrow(() -> new RuntimeException("Author not found"));
        //      Book book = new Book(createBookDto.title(),createBookDto.author(),,1);
        //      return Optional.of(bookRepository.save(book));
        //  }
    //
    @Override
    public Optional<Book> save(CreateBookDto createBookDto) {
        Author author = authorRepository.findById(Long.parseLong(createBookDto.author())).orElseThrow(() -> new RuntimeException("Author not found"));
        Category category = Category.valueOf(createBookDto.category());
        Book book = new Book(createBookDto.title(), category,author,createBookDto.availableCopies());
        return Optional.of(bookRepository.save(book));
    }


    @Override
    public Optional <Book> edit(UpdateBookDto updateBookDto) {
        Book book = bookRepository.findById(updateBookDto.id()).orElseThrow(() -> new RuntimeException("Book not found"));
        Author author = authorRepository.findById(Long.parseLong(updateBookDto.author())).orElseThrow(() -> new RuntimeException("Author not found"));
        book.setTitle(updateBookDto.title());
        book.setCategory(Category.valueOf(updateBookDto.category()));
        book.setAuthor(author);
        book.setAvailableCopies(updateBookDto.availableCopies());
        return Optional.of(bookRepository.save(book));
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
