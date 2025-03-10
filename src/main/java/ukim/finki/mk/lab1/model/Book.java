package ukim.finki.mk.lab1.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ukim.finki.mk.lab1.model.enums.Category;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private Author author;
    private Integer availableCopies;

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
