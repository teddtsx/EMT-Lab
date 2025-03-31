package ukim.finki.mk.lab1.dto;

import ukim.finki.mk.lab1.model.domain.Book;
import java.util.List;

public class WishlistDto {
    private Long id;
    private String username;
    private List<Book> books;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}