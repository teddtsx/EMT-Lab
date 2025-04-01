package ukim.finki.mk.lab1.model.domain;

// File: lab1/src/main/java/ukim/finki/mk/lab1/model/domain/Wishlist.java


import jakarta.persistence.*;

import java.util.List;

@Entity

public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @ManyToMany
    private List<Book> books;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }
}