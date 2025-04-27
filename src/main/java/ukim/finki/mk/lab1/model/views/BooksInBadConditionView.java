package ukim.finki.mk.lab1.model.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Subselect("SELECT * FROM books_in_bad_condition")
@Immutable
public class BooksInBadConditionView {
    @Id
    private Long bookId;

    private String bookName;


    private String category;
}

