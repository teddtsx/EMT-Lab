package ukim.finki.mk.lab1.service.application.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.lab1.dto.WishlistDto;
import ukim.finki.mk.lab1.model.domain.Book;
import ukim.finki.mk.lab1.model.domain.Wishlist;
import ukim.finki.mk.lab1.repository.BookRepository;
import ukim.finki.mk.lab1.repository.UserRepository;
import ukim.finki.mk.lab1.repository.WishlistRepository;
import ukim.finki.mk.lab1.service.application.WishlistService;

@Service
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public WishlistServiceImpl(WishlistRepository wishlistRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.wishlistRepository = wishlistRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public WishlistDto addBookToWishlist(String username, Long bookId) {
        Wishlist wishlist = wishlistRepository.findByUserUsername(username);
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        if (book.getAvailableCopies() > 0) {
            wishlist.getBooks().add(book);
            wishlistRepository.save(wishlist);
        } else {
            throw new RuntimeException("No available copies");
        }
        return mapToDTO(wishlist);
    }

    @Override
    public WishlistDto getWishlist(String username) {
        Wishlist wishlist = wishlistRepository.findByUserUsername(username);
        return mapToDTO(wishlist);
    }

    @Override
    public void rentBooksFromWishlist(String username) {
        Wishlist wishlist = wishlistRepository.findByUserUsername(username);
        for (Book book : wishlist.getBooks()) {
            if (book.getAvailableCopies() > 0) {
                book.setAvailableCopies(book.getAvailableCopies() - 1);
                bookRepository.save(book);
            } else {
                throw new RuntimeException("No available copies for book: " + book.getTitle());
            }
        }
        wishlist.getBooks().clear();
        wishlistRepository.save(wishlist);
    }

    private WishlistDto mapToDTO(Wishlist wishlist) {
        WishlistDto dto = new WishlistDto();
        dto.setId(wishlist.getId());
        dto.setUsername(wishlist.getUser().getUsername());
        dto.setBooks(wishlist.getBooks());
        return dto;
    }
}