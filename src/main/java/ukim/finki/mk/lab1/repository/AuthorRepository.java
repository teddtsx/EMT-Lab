package ukim.finki.mk.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ukim.finki.mk.lab1.model.domain.Author;
import ukim.finki.mk.lab1.projections.AuthorProjection;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long>{
    List<AuthorProjection> findByName();
}
