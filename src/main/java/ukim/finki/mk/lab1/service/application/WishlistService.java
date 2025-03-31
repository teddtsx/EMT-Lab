package ukim.finki.mk.lab1.service.application;

import ukim.finki.mk.lab1.dto.WishlistDto;

public interface WishlistService {
    WishlistDto addBookToWishlist(String username, Long bookId);
    WishlistDto getWishlist(String username);
    void rentBooksFromWishlist(String username);
}
