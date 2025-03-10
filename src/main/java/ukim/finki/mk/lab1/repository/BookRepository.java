package ukim.finki.mk.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ukim.finki.mk.lab1.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
