package ukim.finki.mk.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ukim.finki.mk.lab1.model.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
