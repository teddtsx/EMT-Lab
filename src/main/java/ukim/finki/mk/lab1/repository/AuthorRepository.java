package ukim.finki.mk.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ukim.finki.mk.lab1.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
