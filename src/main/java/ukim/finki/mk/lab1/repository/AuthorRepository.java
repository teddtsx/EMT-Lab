package ukim.finki.mk.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ukim.finki.mk.lab1.model.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
