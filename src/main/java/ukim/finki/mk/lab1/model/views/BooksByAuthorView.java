package ukim.finki.mk.lab1.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Subselect("SELECT * FROM public.books_by_author")
@Immutable
public class BooksByAuthorView {

    @Id
    private Long id;

    private String name;

    private String surname;

    @Column(name = "book_count")
    private Long bookCount;

}